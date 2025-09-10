package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.common.util.DateParserUtil;
import com.gagechaeum.backend.policy.client.Gov24ApiClient;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiResponseDto;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiServiceDto;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicySyncServiceImpl implements PolicySyncService {

    private final Gov24ApiClient gov24ApiClient;
    private final PolicyMapper policyMapper;
    private final PolicyMatchingService policyMatchingService;
    private static final String TARGET_USER_TYPE = "소상공인";
    private static final String TARGET_SUPPORT_TYPE = "현금";

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Override
    @Async("taskExecutor")
    public void syncPolicies() {
        log.info("정책 기본 정보 동기화 호출됨");
        syncPoliciesFromGov24Api();
        log.info("정책 기본 정보 동기화가 완료되었습니다.");

        log.info("새로 추가된 정책들에 대해 Java 기반 카테고리 매칭을 시작합니다.");
        // 카테고리 매칭하는 policyMatchingService 호출
        policyMatchingService.matchAndSaveCategories();
    }

    private void syncPoliciesFromGov24Api() {
        log.info("외부 API 정책 데이터 동기화를 시작합니다.");
        int page = 1;
        int perPage = 30;


        List<Policy> existingPolicies = policyMapper.findAllPolicyIdsWithModificationDate();
        Map<String, LocalDateTime> existingMap = existingPolicies.stream()
                .filter(p -> p.getPolicyId() != null)
                .collect(Collectors.toMap(Policy::getPolicyId, Policy::getModificationDate));

        do {
            Gov24ApiResponseDto apiResponse = gov24ApiClient.fetchPolicies(page, perPage);
            if (apiResponse == null || apiResponse.getData() == null || apiResponse.getData().isEmpty()) {
                log.info("페이지 {}에서 더 이상 데이터가 없습니다. 동기화를 종료합니다.", page);
                break;
            }

            log.info("{} 페이지에서 {}개의 정책을 처리합니다.", page, apiResponse.getCurrentCount());

            for (Gov24ApiServiceDto dto : apiResponse.getData()) {
                if (!isSmallBusinessCashSupportPolicy(dto)) {
                    log.trace("소상공인 대상 현금 지원 정책이 아니므로 건너<binary data, 2 bytes>니다 (policyName: {}, userType: {}, supportType: {})",
                            dto.getServiceName(), dto.getUserType(), dto.getSupportContent());
                    continue; // 조건에 맞지 않으면 다음 정책으로 넘어감
                }


                Policy policy = mapDtoToDomain(dto);
                LocalDateTime existingDate = existingMap.get(policy.getPolicyId());
                boolean needsUpdate = (existingDate == null) ||
                        (policy.getModificationDate() != null && existingDate != null &&
                                policy.getModificationDate().isAfter(existingDate));

                if (needsUpdate) {
                    policyMapper.saveOrUpdatePolicy(policy);
                    log.debug("소상공인 지원금 정책 정보 저장 완료 (policyId: {})", policy.getPolicyId());
                }
            }
            page++;
        } while (true);
        log.info("정책 기본 정보 동기화가 완료되었습니다.");
    }

    private boolean isSmallBusinessCashSupportPolicy(Gov24ApiServiceDto dto) {
        boolean isTargetUser = dto.getUserType() != null && dto.getUserType().contains(TARGET_USER_TYPE);
        boolean isTargetSupport = TARGET_SUPPORT_TYPE.equals(dto.getSupportType());
        // '소상공인'이면서 '현금' 지원 정책이어야 함 (AND 조건)
        return isTargetUser && isTargetSupport;
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