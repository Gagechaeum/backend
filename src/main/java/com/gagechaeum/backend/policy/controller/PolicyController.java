package com.gagechaeum.backend.policy.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.policy.dto.response.PolicyDocumentsResponseDTO;
import com.gagechaeum.backend.policy.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.policy.service.PolicyService;
import com.gagechaeum.backend.policy.service.PolicySyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
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
        log.info("컨트롤러에서 정책 기본 정보 동기화(sync) 호출");
        policySyncService.syncPolicies(); // async 제거된 메소드 호출
        return ResponseEntity.ok("Policy basic info synchronization completed.");
    }

    @PostMapping("/sync-details")
    public ResponseEntity<String> syncPolicyDetails() {
        log.info("컨트롤러에서 정책 상세 정보 동기화(sync-details) 호출");
        policySyncService.syncPolicyDetails(); // async 제거된 메소드 호출
        return ResponseEntity.ok("Policy detail info synchronization started. This may take a long time.");
    }

    @GetMapping("/{policyId}/documents")
    public CustomResponse<PolicyDocumentsResponseDTO> getPolicyDocuments(@PathVariable String policyId) {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        PolicyDocumentsResponseDTO response = policyService.getPolicyDocuments(policyId, userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
    
    @GetMapping("/{policy_id}")
    public CustomResponse<Object> getPolicyDetails(@PathVariable("policy_id") String policyId) {
        Object response = policyService.getPolicyDetails(policyId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @PostMapping("/sync-apply")
    public ResponseEntity<String> applyPolicyDetails() {
        log.info("컨트롤러에서 최종 데이터 반영(sync-apply) 호출");
        policySyncService.applyPolicyDetailsAsync();
        return ResponseEntity.ok("Applying policy details from temp table started.");
    }
}
