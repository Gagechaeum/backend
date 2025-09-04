package com.gagechaeum.backend.policy.dto.response;

import com.gagechaeum.backend.policy.domain.Policy;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PolicyInfoDTO {
    private String policyId;
    private String policyName;
    private String policySummary;
    private String departmentName;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String applicationPeriod;
    private Long bookmarkCount;

    public static PolicyInfoDTO from(Policy policy) {
        return PolicyInfoDTO.builder()
                .policyId(policy.getPolicyId())
                .policyName(policy.getPolicyName())
                .policySummary(policy.getPolicySummary())
                .departmentName(policy.getDepartmentName())
                .beginDate(policy.getBeginDate())
                .endDate(policy.getEndDate())
                .applicationPeriod(policy.getApplicationPeriod())
                .bookmarkCount(policy.getBookmarkCount())
                .build();
    }
}