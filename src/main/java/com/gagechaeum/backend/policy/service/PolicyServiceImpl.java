package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.dto.response.PolicyDetailResponseDto;
import com.gagechaeum.backend.policy.domain.Policy;
import com.gagechaeum.backend.policy.dto.response.PolicyDocumentsResponseDTO;
import com.gagechaeum.backend.policy.dto.response.PolicyInfoDTO;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.policy.mapper.PolicyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private final PolicyMapper policyMapper;

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
            throw new IllegalArgumentException( "정책이 존재하지 않습니다.");
        }
        policy.parseAndSetRequiredDocuments();
        return PolicyDetailResponseDto.fromVo(policy);
    }

    @Override
    @Transactional(readOnly = true)
    public PolicyDocumentsResponseDTO getPolicyDocuments(String policyId, Long userId) {
        Policy policy = policyMapper.getPolicyById(policyId);
        if (policy == null) {
            throw new IllegalArgumentException( "정책의 서류가 존재하지 않습니다.");
        }

        List<PolicyDocumentsResponseDTO.StructuredDocumentDTO> structuredDocuments = policyMapper.findStructuredDocumentsByPolicyId(policyId, userId);

        return PolicyDocumentsResponseDTO.builder()
                .structuredDocuments(structuredDocuments)
                .unstructuredDocumentText(policy.getRequiredDocumentsRawText())
                .build();
    }
}