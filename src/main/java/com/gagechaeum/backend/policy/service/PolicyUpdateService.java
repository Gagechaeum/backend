package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.DocumentKeywordDTO;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiDetailResponseDto;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyUpdateService {

    private final PolicyMapper policyMapper;

    @Transactional
    public void processAndSavePolicyDetail(String policyId, Gov24ApiDetailResponseDto detailDto, List<DocumentKeywordDTO> documentKeywords) {
        if (detailDto == null || detailDto.getData() == null || detailDto.getData().isEmpty()) {
            log.warn("[정책ID: {}] 외부 API로부터 상세 정보를 받아오지 못했습니다. 구비서류가 업데이트되지 않습니다.", policyId);
            return;
        }

        // 중요: 이 메소드 안에서 policyId를 사용해 직접 Policy 객체를 조회합니다.
        // 이렇게 하면 다른 비동기 작업의 영향을 받지 않는 깨끗한 객체를 보장할 수 있습니다.
        Policy policy = policyMapper.getPolicyById(policyId);
        if (policy == null) {
            log.error("[정책ID: {}] DB에 존재하지 않는 정책입니다. 상세 정보 업데이트를 건너뜁니다.", policyId);
            return;
        }

        String rawText = detailDto.getData().get(0).getRequiredDocumentsText();

        // 디버깅을 위한 로그: 어떤 ID에 어떤 텍스트가 저장되는지 명확히 확인
        log.info("[SAVE_CHECK] Policy ID: {} 에 저장될 텍스트: '{}'", policy.getPolicyId(), rawText);

        // 데이터가 실제로 변경되었을 때만 업데이트
        if (!Objects.equals(rawText, policy.getRequiredDocumentsRawText())) {
            policy.setRequiredDocumentsRawText(rawText);

            // 이 메소드는 Policy 도메인에 있다고 가정합니다. 없다면 주석 처리해주세요.
            // policy.parseAndSetRequiredDocuments();

            policyMapper.saveOrUpdatePolicy(policy);
            updateRequiredDocumentsMapping(policy, documentKeywords);
            log.info("정책 상세 정보 업데이트 완료 (policyId: {})", policy.getPolicyId());
        } else {
            log.debug("정책 상세 정보 변경 없음 (policyId: {})", policy.getPolicyId());
        }
    }

    private void updateRequiredDocumentsMapping(Policy policy, List<DocumentKeywordDTO> documentKeywords) {
        policyMapper.deleteRequiredDocumentsByPolicyId(policy.getPolicyId());
        String rawText = policy.getRequiredDocumentsRawText();
        if (rawText != null && !rawText.isBlank()) {
            for (DocumentKeywordDTO doc : documentKeywords) {
                if (doc.getKeywords() == null || doc.getKeywords().isBlank()) {
                    continue;
                }
                String[] keywords = doc.getKeywords().split(",");
                boolean isMatched = Arrays.stream(keywords)
                        .anyMatch(keyword -> rawText.contains(keyword.trim()));
                if (isMatched) {
                    policyMapper.insertRequiredDocument(policy.getPolicyId(), doc.getDocumentId());
                }
            }
        }
    }
}