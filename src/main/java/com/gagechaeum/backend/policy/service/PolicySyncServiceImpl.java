package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.common.util.DateParserUtil;
import com.gagechaeum.backend.policy.client.Gov24ApiClient;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiResponseDto;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiServiceDto;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicySyncServiceImpl implements PolicySyncService {

    private final Gov24ApiClient gov24ApiClient;
    private final PolicyMapper policyMapper;
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Override
    @Transactional
    public void syncPoliciesFromGov24Api() {
        log.info("외부 API 정책 데이터 동기화를 시작합니다.");
        int page = 1;
        int perPage = 100; // 한 번에 100건씩 가져오도록 설정
        int totalPages = 1; // 루프 진입을 위해 초기값 1로 설정
        int totalSyncedCount = 0;

        // 모든 페이지를 순회하기 위한 do-while 루프
        do {
            Gov24ApiResponseDto apiResponse = gov24ApiClient.fetchPolicies(page, perPage);

            if (apiResponse == null || apiResponse.getData() == null || apiResponse.getData().isEmpty()) {
                log.warn("{} 페이지에서 데이터를 받지 못했습니다. 동기화를 중단합니다.", page);
                break;
            }

            // 첫 번째 페이지를 조회했을 때만 전체 페이지 수를 계산
            if (page == 1) {
                totalPages = (int) Math.ceil((double) apiResponse.getTotalCount() / perPage);
                log.info("총 {}개의 정책, {} 페이지에 걸쳐 동기화를 진행합니다.", apiResponse.getTotalCount(), totalPages);
            }

            List<Gov24ApiServiceDto> apiPolicies = apiResponse.getData();
            log.info("{} 페이지에서 {}건의 정책을 가져왔습니다.", page, apiPolicies.size());

            for (Gov24ApiServiceDto dto : apiPolicies) {
                Policy policy = mapDtoToDomain(dto);
                policyMapper.saveOrUpdatePolicy(policy);
                totalSyncedCount++;
            }

            page++;

        } while (page <= totalPages);

        log.info("총 {}건의 정책 데이터 동기화가 완료되었습니다.", totalSyncedCount);
    }

    private Policy mapDtoToDomain(Gov24ApiServiceDto dto) {
        Policy policy = new Policy();

        if (dto.getServiceId() != null && !dto.getServiceId().isBlank()) {
            policy.setPolicyId(dto.getServiceId());
        }

        policy.setPolicyName(getOrDefault(dto.getServiceName(), "정책 이름 정보 없음"));
        policy.setPolicySummary(getOrDefault(dto.getServiceSummary(), "요약 정보 없음"));
        policy.setDepartmentName(getOrDefault(dto.getDepartmentName(), "부서 정보 없음"));
        policy.setSupervisingOrganizationName(getOrDefault(dto.getOrganizationName(), "소관 기관 정보 없음"));
        policy.setAnnouncementUrl(getOrDefault(dto.getDetailUrl(), "#"));
        policy.setSupportDetail(getOrDefault(dto.getSupportContent(), "지원 내용 정보 없음"));
        policy.setApplicationPeriod(getOrDefault(dto.getApplicationPeriod(), "신청 기간 정보 없음"));
        policy.setUserType(getOrDefault(dto.getUserType(), "정보 없음"));
        policy.setPolicyField(getOrDefault(dto.getPolicyField(), "분야 정보 없음"));
        policy.setApplicationMethod(getOrDefault(dto.getApplicationMethod(), "신청 방법 정보 없음"));
        policy.setSupportTarget(getOrDefault(dto.getSupportTarget(), "지원 대상 정보 없음"));

        if (dto.getNoticeDate() != null) {
            policy.setNoticeDate(LocalDateTime.parse(dto.getNoticeDate(), DATETIME_FORMATTER));
        }
        if (dto.getModificationDate() != null) {
            policy.setModificationDate(LocalDateTime.parse(dto.getModificationDate(), DATETIME_FORMATTER));
        }

        LocalDate[] dates = DateParserUtil.parseDateRange(dto.getApplicationPeriod());
        policy.setBeginDate(dates[0]);
        policy.setEndDate(dates[1]);

        return policy;
    }

    private String getOrDefault(String value, String defaultValue) {
        return (value != null && !value.isBlank()) ? value : defaultValue;
    }
}