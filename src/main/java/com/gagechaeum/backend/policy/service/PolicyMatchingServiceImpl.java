package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.domain.Industry;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.domain.Regions;
import com.gagechaeum.backend.policy.mapper.IndustryMapper;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import com.gagechaeum.backend.policy.mapper.RegionMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyMatchingServiceImpl implements PolicyMatchingService {

    private final PolicyMapper policyMapper;
    private final RegionMapper regionMapper;
    private final IndustryMapper industryMapper;

    private List<Regions> regionCacheForMatching;
    private List<Industry> industryCacheForMatching;
    private Long nationwideRegionId;
    private Long overallIndustryId;

    @Override
    @Transactional
    public void matchAndSaveCategories() {
        log.info("Java 기반 정책-카테고리 매칭 및 업데이트를 시작합니다.");

        // 메서드가 호출될 때 캐시 변수가 null인지 확인하고, null일 경우에만 초기화
        if (this.regionCacheForMatching == null || this.industryCacheForMatching == null) {
            log.warn("캐시가 초기화되지 않았습니다. 지금 즉시 캐시를 초기화합니다.");

            // --- 지역 캐시 초기화 ---
            List<Regions> allRegions = regionMapper.findAll();
            this.nationwideRegionId = allRegions.stream()
                    .filter(region -> "전국".equals(region.getName()))
                    .map(Regions::getRegionId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("'전국' 지역이 DB에 존재하지 않습니다."));

            this.regionCacheForMatching = allRegions.stream()
                    .filter(region -> !"전국".equals(region.getName()))
                    .sorted(Comparator.comparingInt((Regions r) -> r.getFullName().length()).reversed())
                    .collect(Collectors.toList());

            // 업종 캐시 초기화
            List<Industry> allIndustries = industryMapper.findAll();
            this.overallIndustryId = allIndustries.stream()
                    .filter(industry -> "전체".equals(industry.getName()))
                    .map(Industry::getIndustryId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("'전체' 업종이 DB에 존재하지 않습니다."));

            this.industryCacheForMatching = allIndustries.stream()
                    .filter(industry -> !"전체".equals(industry.getName()))
                    .collect(Collectors.toList());

            log.info("캐싱 완료: {}개 지역, {}개 업종", regionCacheForMatching.size(), industryCacheForMatching.size());
        }

        List<Policy> policiesToMatch = policyMapper.findPoliciesForMatching();

        if (policiesToMatch.isEmpty()) {
            log.info("새롭게 매칭할 정책이 없습니다. 프로세스를 종료합니다.");
            return;
        }

        log.info("총 {}개의 정책에 대해 매칭을 시작합니다.", policiesToMatch.size());
        for (Policy policy : policiesToMatch) {

            Long regionId = findRegionId(policy);
            Long industryId = findIndustryId(policy);

            // 미분류 지역은 전국으로 설정
            if (regionId == null) {
                regionId = this.nationwideRegionId;
            }
            // 미분류 업종은 전체로 설정
            if (industryId == null) {
                industryId = this.overallIndustryId;
            }

            policyMapper.updatePolicyCategories(policy.getPolicyId(), regionId, industryId);
        }
        log.info("Java 기반 정책-카테고리 매칭 및 업데이트가 완료되었습니다.");
    }

    private String buildPolicyTextForMatching(Policy policy) {
        return String.join(" ",
                policy.getPolicyName(),
                policy.getSupervisingOrganizationName(),
                policy.getSupportTarget()
        );
    }

    private Long findRegionId(Policy policy) {
        String organizationName = policy.getSupervisingOrganizationName();
        if (organizationName == null || organizationName.isBlank()) {
            return null;
        }

        return regionCacheForMatching.stream()
                .filter(region -> organizationName.contains(region.getFullName()))
                .map(Regions::getRegionId)
                .findFirst()
                .orElse(null);
    }

    private Long findIndustryId(Policy policy) {
        // 업종 분석을 위해 더 많은 텍스트 정보를 조합
        String policyTextForIndustry = String.join(" ",
                policy.getPolicyName(),
                policy.getSupportTarget(),
                policy.getPolicySummary(),
                policy.getSupportDetail()
        );

        return industryCacheForMatching.stream()
                .filter(industry -> {
                    // 1. 업종 이름이 직접 포함되어 있는지 확인
                    boolean nameMatches = policyTextForIndustry.contains(industry.getName());
                    if (nameMatches) return true;

                    // 2. 업종 관련 키워드가 포함되어 있는지 확인
                    if (industry.getKeywords() != null && !industry.getKeywords().isBlank()) {
                        return Arrays.stream(industry.getKeywords().split(","))
                                .anyMatch(keyword -> policyTextForIndustry.contains(keyword.trim()));
                    }
                    return false;
                })
                .map(Industry::getIndustryId)
                .findFirst()
                .orElse(null);
    }
}