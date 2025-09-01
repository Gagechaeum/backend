package com.gagechaeum.backend.recommendation.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.recommendation.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/policies")
    public CustomResponse<PolicyRecommendationResponseDTO> recommendPolicies(
            @RequestParam Long userId // @AuthenticationPrincipal 대신 @RequestParam 사용
    ) {
        // user.getUserId() 대신 파라미터로 받은 userId를 바로 사용
        PolicyRecommendationResponseDTO response = recommendationService.getRecommendedPolicies(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}