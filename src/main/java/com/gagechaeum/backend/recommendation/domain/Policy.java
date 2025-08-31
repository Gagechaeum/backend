package com.gagechaeum.backend.recommendation.domain;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Policy {
    private Long policyId;
    private String policyName;
    private String policySummary;
    private String departmentName;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Long bookmarkCount;
}
