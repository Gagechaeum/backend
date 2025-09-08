package com.gagechaeum.backend.policy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class NewPolicyDetail {

    private Long id;
    private String policyId;
    private String rawText;
    private LocalDateTime updatedAt;

    @Builder
    public NewPolicyDetail(String policyId, String rawText, LocalDateTime updatedAt) {
        this.policyId = policyId;
        this.rawText = rawText;
        this.updatedAt = updatedAt;
    }
}
