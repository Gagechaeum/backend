package com.gagechaeum.backend.policy.service;

import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;

public interface PolicyService {
    PolicyRecommendationResponseDTO getRecommendedPolicies(Long userId);
}
