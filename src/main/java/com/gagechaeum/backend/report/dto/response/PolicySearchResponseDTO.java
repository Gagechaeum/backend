package com.gagechaeum.backend.report.dto.response;

import com.gagechaeum.backend.report.domain.PolicySearchResult;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PolicySearchResponseDTO {
    private final String policyId;
    private final String policyName;

    @Builder
    public PolicySearchResponseDTO(String policyId, String policyName) {
        this.policyId = policyId;
        this.policyName = policyName;
    }

    public static PolicySearchResponseDTO from(PolicySearchResult domain) {
        return PolicySearchResponseDTO.builder()
                .policyId(domain.getPolicyId())
                .policyName(domain.getPolicyName())
                .build();
    }
}