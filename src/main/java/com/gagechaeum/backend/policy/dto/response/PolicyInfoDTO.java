package com.gagechaeum.backend.policy.dto.response;

import com.gagechaeum.backend.policy.domain.Policy;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PolicyInfoDTO {
    private Long policyId;
    private String policyName;
    private String policySummary;
    private String departmentName;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Long bookmarkCount;

    // Policy VO를 PolicyInfo DTO로 변환하는 정적 메소드 추가
    public static PolicyInfoDTO from(Policy policy) {
        return PolicyInfoDTO.builder()
                .policyId(policy.getPolicyId())
                .policyName(policy.getPolicyName())
                .policySummary(policy.getPolicySummary())
                .departmentName(policy.getDepartmentName())
                .beginDate(policy.getBeginDate())
                .endDate(policy.getEndDate())
                .bookmarkCount(policy.getBookmarkCount())
                .build();
    }
}