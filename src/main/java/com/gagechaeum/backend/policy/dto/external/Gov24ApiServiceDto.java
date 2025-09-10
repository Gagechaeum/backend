package com.gagechaeum.backend.policy.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Gov24ApiServiceDto {

    @JsonProperty("서비스ID")
    private String serviceId;

    @JsonProperty("서비스명")
    private String serviceName;

    @JsonProperty("서비스목적요약")
    private String serviceSummary;

    @JsonProperty("부서명")
    private String departmentName;

    @JsonProperty("상세조회URL")
    private String detailUrl;

    @JsonProperty("지원내용")
    private String supportContent;

    @JsonProperty("선정기준")
    private String selectionCriteria;

    @JsonProperty("신청기한")
    private String applicationPeriod;

    @JsonProperty("사용자구분")
    private String userType;

    @JsonProperty("서비스분야")
    private String policyField;

    @JsonProperty("등록일시")
    private String noticeDate;

    @JsonProperty("수정일시")
    private String modificationDate;

    @JsonProperty("신청방법")
    private String applicationMethod;

    @JsonProperty("전화문의")
    private String contact;

    @JsonProperty("지원대상")
    private String supportTarget;

    @JsonProperty("소관기관명")
    private String organizationName;

    @JsonProperty("지원유형")
    private String supportType;
}
