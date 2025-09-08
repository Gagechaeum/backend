package com.gagechaeum.backend.policy.dto.python;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchingResultDto {
    private String policyId;
    private Long regionId;
    private Long industryId;
}