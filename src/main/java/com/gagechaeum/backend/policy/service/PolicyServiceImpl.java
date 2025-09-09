package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.document.domain.Document;
import com.gagechaeum.backend.document.domain.RequiredDocument;
import com.gagechaeum.backend.document.mapper.DocumentMapper;
import com.gagechaeum.backend.document.mapper.RequiredDocumentMapper;
import com.gagechaeum.backend.policy.client.Gov24ApiClient;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiDetailResponseDto;
import com.gagechaeum.backend.policy.dto.response.PolicyDetailResponseDto;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.response.PolicyInfoDTO;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private final Gov24ApiClient gov24ApiClient;
    private final PolicyMapper policyMapper;
    private final DocumentMapper documentMapper;
    private final RequiredDocumentMapper requiredDocumentMapper;

    @Override
    @Transactional(readOnly = true)
    public PolicyRecommendationResponseDTO getRecommendedPolicies(Long userId) {
        List<Policy> policies = policyMapper.findRecommendedPoliciesByUserId(userId);

        List<PolicyInfoDTO> policyInfos = policies.stream()
                .map(PolicyInfoDTO::from)
                .collect(Collectors.toList());

        return PolicyRecommendationResponseDTO.from(policyInfos);
    }

    @Override
    public PolicyDetailResponseDto getPolicyDetails(String policyId) {
        Policy policy = policyMapper.getPolicyById(policyId);
        if (policy == null) {
            throw new IllegalArgumentException("정책이 존재하지 않습니다.");
        }
        policy.parseAndSetRequiredDocuments();
        return PolicyDetailResponseDto.fromVo(policy);
    }

    @Override
    @Transactional
    public void fetchAndSavePolicyDocuments(String serviceId) {
        int page = 1;
        final int perPage = 100;

        List<Document> allDocuments = documentMapper.findAll();
        Document etcDocument = allDocuments.stream()
                .filter(doc -> "기타".equals(doc.getDocumentName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("'기타' 서류가 DB에 없습니다."));

        while (true) {
            // 1. 외부 API 동기 호출 (수정된 클라이언트 메서드 사용)
            Gov24ApiDetailResponseDto response = gov24ApiClient.fetchPolicyDetailsSync(serviceId, page, perPage);

            // 2. 루프 종료 조건: 응답이 없거나 데이터가 비어있으면 반복 중단
            if (response == null || response.getData() == null || response.getData().isEmpty()) {
                break; // while 루프 탈출
            }

            // 3. 받아온 데이터 처리 (기존 코드 재사용)
            response.getData().forEach(detailDto -> {
                String rawText = detailDto.getRequiredDocuments();

                // 임시 테이블에 원본 텍스트 저장
                policyMapper.saveOrUpdateTempPolicyDetail(detailDto.getServiceId(), rawText, LocalDateTime.now());

                if (!StringUtils.hasText(rawText) || "해당없음".equals(rawText)) {
                    return; // 서류 정보 없으면 다음 데이터로
                }

                // 원본 텍스트 파싱하여 required_documents에 저장
                Arrays.stream(rawText.split(","))
                        .map(String::trim)
                        .filter(StringUtils::hasText)
                        .map(rawDocName -> allDocuments.stream()
                                .filter(stdDoc -> StringUtils.hasText(stdDoc.getKeywords()) &&
                                        Arrays.stream(stdDoc.getKeywords().split(","))
                                                .anyMatch(keyword -> rawDocName.contains(keyword.trim())))
                                .findFirst()
                                .orElse(etcDocument))
                        .distinct()
                        .forEach(matchedDoc -> {
                            RequiredDocument requiredDocument = RequiredDocument.builder()
                                    .policyId(detailDto.getServiceId())
                                    .documentId(matchedDoc.getDocumentId())
                                    .build();
                            requiredDocumentMapper.save(requiredDocument);
                        });
            });

            // 4. 다음 페이지로 이동
            page++;
        }
    }
}