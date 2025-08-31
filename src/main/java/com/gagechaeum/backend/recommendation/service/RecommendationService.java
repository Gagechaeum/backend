package com.gagechaeum.backend.recommendation.service;

import com.gagechaeum.backend.recommendation.dto.response.PolicyRecommendationResponseDTO;

public interface RecommendationService {
    PolicyRecommendationResponseDTO getRecommendedPolicies(Long userId);
}
