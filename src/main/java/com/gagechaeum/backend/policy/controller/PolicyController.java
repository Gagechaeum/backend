package com.gagechaeum.backend.policy.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.policy.service.PolicyService;
import com.gagechaeum.backend.policy.service.PolicySyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;
    private final PolicySyncService policySyncService;

    @GetMapping("/recommendation")
    public CustomResponse<PolicyRecommendationResponseDTO> recommendPolicies(
            @RequestParam(required = false) Long userId
    ) {
        PolicyRecommendationResponseDTO response = policyService.getRecommendedPolicies(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @PostMapping("/sync")
    public ResponseEntity<String> syncPolicies() {
        policySyncService.syncPoliciesFromGov24Api();
        return ResponseEntity.ok("Policy synchronization started.");
    }
}
