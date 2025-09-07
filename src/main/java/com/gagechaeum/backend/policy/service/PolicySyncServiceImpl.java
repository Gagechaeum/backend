package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.common.util.DateParserUtil;
import com.gagechaeum.backend.policy.client.Gov24ApiClient;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.DocumentKeywordDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicySyncServiceImpl implements PolicySyncService {

    private final Gov24ApiClient gov24ApiClient;
    private final PolicyMapper policyMapper;
    private final PolicyUpdateService policyUpdateService; // 의존성 주입
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Async
    @Override
    public void syncPoliciesAsync() {
        log.info("비동기 정책 동기화 호출됨");
        syncPoliciesFromGov24Api();
    }

    @Async
    @Override
    public void syncPolicyDetailsAsync() {
        log.info("비동기 정책 상세 동기화 호출됨");
        syncPolicyDetailsFromDB();
    }

    private void syncPoliciesFromGov24Api() {
        log.info("외부 API 정책 데이터 동기화를 시작합니다.");

        int page = 1;
        int perPage = 30;
        int totalPages = 1;

        List<Policy> existingPolicies = policyMapper.findAllPolicyIdsWithModificationDate();
        Map<String, LocalDateTime> existingMap = existingPolicies.stream()
                .filter(p -> p.getPolicyId() != null)
                .collect(Collectors.toMap(Policy::getPolicyId, Policy::getModificationDate));

        do {
            Gov24ApiResponseDto apiResponse = gov24ApiClient.fetchPolicies(page, perPage);

            if (apiResponse == null || apiResponse.getData() == null || apiResponse.getData().isEmpty()) {
                log.warn("{} 페이지에서 데이터를 받지 못했습니다. 동기화를 중단합니다.", page);
                break;
            }

            if (page == 1) {
                totalPages = (int) Math.ceil((double) apiResponse.getTotalCount() / perPage);
                log.info("총 {}개의 정책, {} 페이지에 걸쳐 동기화를 진행합니다.", apiResponse.getTotalCount(), totalPages);
            }

            for (Gov24ApiServiceDto dto : apiResponse.getData()) {
                Policy policy = mapDtoToDomain(dto);

                LocalDateTime existingDate = existingMap.get(policy.getPolicyId());
                boolean needsUpdate = (existingDate == null) ||
                        (policy.getModificationDate() != null && existingDate != null &&
                                policy.getModificationDate().isAfter(existingDate));

                if (needsUpdate) {
                    policyMapper.saveOrUpdatePolicy(policy);
                    log.debug("정책 기본 정보 저장 완료 (policyId: {})", policy.getPolicyId());
                }
            }

            page++;
        } while (page <= totalPages);

        log.info("정책 기본 정보 동기화가 완료되었습니다.");
    }

    // ======================= 여기가 수정된 메소드입니다 =======================
    // PolicySyncServiceImpl.java

    private void syncPolicyDetailsFromDB() {
        log.info("DB의 모든 정책에 대한 상세 정보 동기화를 시작합니다.");
        List<Policy> allPolicies = policyMapper.findAllPolicies();
        List<DocumentKeywordDTO> documentKeywords = policyMapper.findAllDocumentsWithKeywords();

        if (allPolicies == null || allPolicies.isEmpty()) {
            log.warn("상세 정보를 동기화할 정책이 DB에 없습니다.");
            return;
        }
        log.info("DB에서 {}개의 정책과 {}개의 서류 키워드를 조회했습니다.", allPolicies.size(), documentKeywords.size());

        final int batchSize = 100;

        List<List<Policy>> batches = new ArrayList<>();
        for (int i = 0; i < allPolicies.size(); i += batchSize) {
            batches.add(allPolicies.subList(i, Math.min(i + batchSize, allPolicies.size())));
        }

        // 각 배치를 순서대로 처리합니다.
        for (int i = 0; i < batches.size(); i++) {
            List<Policy> currentBatch = batches.get(i);
            log.info("Batch {}/{} 처리 시작 ({}개 정책)", i + 1, batches.size(), currentBatch.size());

            // ★★★★★★★★★★★★★★★  핵심 변경점 ★★★★★★★★★★★★★★★
            // Stream.map().collect() 대신, 명시적인 for-each 루프와 리스트를 사용합니다.

            List<CompletableFuture<Void>> futuresInBatch = new ArrayList<>();

            for (Policy policy : currentBatch) {
                // for-each 루프 안에서 'policy' 변수는 매번 새롭고 명확하게 할당됩니다.
                CompletableFuture<Void> future = gov24ApiClient.fetchPolicyDetails(policy.getPolicyId())
                        .thenAccept(detailDto -> {
                            // 이제 이 콜백은 절대 다른 policy를 참조할 수 없습니다.
                            policyUpdateService.processAndSavePolicyDetail(policy.getPolicyId(), detailDto, documentKeywords);
                        })
                        .exceptionally(e -> {
                            log.error("정책 상세 정보 처리 중 오류 발생 (policyId: {}): {}", policy.getPolicyId(), e.getMessage());
                            return null;
                        });
                futuresInBatch.add(future);
            }

            // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

            // 현재 배치의 모든 작업이 끝날 때까지 여기서 기다립니다.
            CompletableFuture.allOf(futuresInBatch.toArray(new CompletableFuture[0])).join();

            log.info("Batch {}/{} 처리 완료.", i + 1, batches.size());
        }

        log.info("총 {}건의 정책 상세 정보 동기화가 완료되었습니다.", allPolicies.size());
    }

    private Policy mapDtoToDomain(Gov24ApiServiceDto dto) {
        Policy policy = new Policy();
        // ... (이하 동일)
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