package com.gagechaeum.backend.policy.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.policy.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    // 정책 추천
    @GetMapping("/recommendation")
    public CustomResponse<PolicyRecommendationResponseDTO> recommendPolicies(
            @RequestParam Long userId // @AuthenticationPrincipal 대신 @RequestParam 사용
    ) {
        // user.getUserId() 대신 파라미터로 받은 userId를 바로 사용
        PolicyRecommendationResponseDTO response = policyService.getRecommendedPolicies(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}