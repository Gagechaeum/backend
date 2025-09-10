package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.dto.request.PolicyListRequestDto;
import com.gagechaeum.backend.policy.dto.response.PolicyDetailResponseDto;
import com.gagechaeum.backend.policy.dto.response.PolicyListResponseDto;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;

public interface PolicyService {
    PolicyListResponseDto getPolicyList(PolicyListRequestDto requestDto);
    
    PolicyRecommendationResponseDTO getRecommendedPolicies(Long userId);

    PolicyDetailResponseDto getPolicyDetails(String policyId);

    void fetchAndSavePolicyDocuments(String serviceId);
}
