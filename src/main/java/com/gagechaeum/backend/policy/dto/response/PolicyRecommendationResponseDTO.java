package com.gagechaeum.backend.policy.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PolicyRecommendationResponseDTO {
    private List<PolicyInfoDTO> policies;

    public static PolicyRecommendationResponseDTO from(List<PolicyInfoDTO> policies) {
        return PolicyRecommendationResponseDTO.builder()
                .policies(policies)
                .build();
    }
}
