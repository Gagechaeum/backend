package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.document.domain.NewDocument;
import com.gagechaeum.backend.document.domain.NewRequiredDocument;
import com.gagechaeum.backend.document.mapper.NewDocumentMapper;
import com.gagechaeum.backend.document.mapper.NewRequiredDocumentMapper;
import com.gagechaeum.backend.policy.client.NewGov24ApiClient;
import com.gagechaeum.backend.policy.domain.NewPolicyDetail;
import com.gagechaeum.backend.policy.dto.NewPolicyApiResponseDto;
import com.gagechaeum.backend.policy.mapper.NewPolicyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NewPolicyServiceImpl implements NewPolicyService {

    private final NewGov24ApiClient newGov24ApiClient;
    private final NewPolicyMapper newPolicyMapper;
    private final NewDocumentMapper newDocumentMapper;
    private final NewRequiredDocumentMapper newRequiredDocumentMapper;

    @Override
    @Transactional
    public void fetchAndSavePolicyDocuments(String serviceId) {
        // 1. 외부 API 호출
        NewPolicyApiResponseDto response = newGov24ApiClient.fetchServiceDetail(serviceId);

        if (response == null || response.getData() == null || response.getData().isEmpty()) {
            return;
        }

        // 2. 모든 표준 서류 정보 조회
        List<NewDocument> allDocuments = newDocumentMapper.findAll();
        NewDocument etcDocument = allDocuments.stream()
                .filter(doc -> "기타".equals(doc.getDocumentName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("'기타'에 해당하는 서류가 DB에 존재하지 않습니다."));

        response.getData().forEach(detailDto -> {
            String rawText = detailDto.getRequiredDocuments();

            // 3. 임시 테이블에 원본 텍스트 저장
            NewPolicyDetail policyDetail = NewPolicyDetail.builder()
                    .policyId(detailDto.getServiceId())
                    .rawText(rawText)
                    .updatedAt(LocalDateTime.now())
                    .build();
            newPolicyMapper.savePolicyDetail(policyDetail);

            if (!StringUtils.hasText(rawText) || "해당없음".equals(rawText)) {
                return;
            }

            // 4. 원본 텍스트를 파싱하여 required_documents에 저장
            Arrays.stream(rawText.split(","))
                    .map(String::trim)
                    .map(rawDocName -> {
                        return allDocuments.stream()
                                .filter(stdDoc -> StringUtils.hasText(stdDoc.getKeywords()) && Arrays.stream(stdDoc.getKeywords().split(",")).anyMatch(rawDocName::contains))
                                .findFirst()
                                .orElse(etcDocument);
                    })
                    .distinct() // 중복된 서류 ID 제거
                    .forEach(matchedDoc -> {
                        NewRequiredDocument requiredDocument = NewRequiredDocument.builder()
                                .policyId(detailDto.getServiceId())
                                .documentId(matchedDoc.getDocumentId())
                                .build();
                        newRequiredDocumentMapper.save(requiredDocument);
                    });
        });
    }
}
