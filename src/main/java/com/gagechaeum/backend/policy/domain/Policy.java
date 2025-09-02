package com.gagechaeum.backend.policy.domain;

import com.gagechaeum.backend.policy.dto.external.Gov24ApiServiceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Policy {
    private String policyId;
    private Long industryId;
    private Long regionId;
    private String departmentName;
    private String userType;
    private String announcementUrl;
    private String policyName;
    private String policySummary;
    private String policyField;
    private String selectionCriteria;
    private String supervisingOrganizationName;
    private String receivingOrganizationName;
    private LocalDateTime noticeDate;
    private LocalDateTime modificationDate;
    private Long bookmarkCount;

    // 원본 신청 기간 텍스트
    private String applicationPeriod;

    // 파싱된 날짜
    private LocalDate beginDate;
    private LocalDate endDate;

    private String applicationMethod;
    private String contact;
    private String supportDetail;
    private String supportTarget;
}
