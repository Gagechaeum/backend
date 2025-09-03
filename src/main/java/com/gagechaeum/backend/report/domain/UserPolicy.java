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
    private String status; // This seems to be from the old structure, keeping for now
    private Long approvedAmount; // This seems to be from the old structure, keeping for now
    private LocalDate depositDate; // This seems to be from the old structure, keeping for now
    private LocalDate policyBeginDate; // This seems to be from the old structure, keeping for now
    private LocalDate policyEndDate; // This seems to be from the old structure, keeping for now

}
