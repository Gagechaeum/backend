package com.gagechaeum.backend.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPolicy {
    private Long userPolicyId;
    private Long userId;
    private String policyId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate firstPaymentDate;
    private Integer monthlyAmount;
    private Integer totalAmount;

    // Joined fields
    private String policyName;

    

}
