package com.gagechaeum.backend.report.domain;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class UserPolicy {
    private Long userPolicyId;
    private String status;
    private Long approvedAmount;
    private LocalDate depositDate;

    // Join된 Policy 정보
    private String policyName;
    private LocalDate policyBeginDate;
    private LocalDate policyEndDate;
}
