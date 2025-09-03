package com.gagechaeum.backend.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PolicySearchResult {
    private String policyId;
    private String policyName;
}