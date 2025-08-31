package com.gagechaeum.backend.recommendation.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.recommendation.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.recommendation.service.RecommendationService;
import com.gagechaeum.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/policies")
    public CustomResponse<PolicyRecommendationResponseDTO> recommendPolicies(
            @AuthenticationPrincipal User user
    ) {
        PolicyRecommendationResponseDTO response = recommendationService.getRecommendedPolicies(user.getUserId());
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}