package com.gagechaeum.backend.policy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Policy {
    private Long id;

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

    private String requiredDocumentsRawText;

    // 파싱된 필요 서류 목록
    private List<String> requiredDocuments;

    @Builder
    public Policy(Long id, String policyId, Long industryId, Long regionId, String departmentName, String userType, String announcementUrl, String policyName, String policySummary, String policyField, String selectionCriteria, String supervisingOrganizationName, String receivingOrganizationName, LocalDateTime noticeDate, LocalDateTime modificationDate, Long bookmarkCount, String applicationPeriod, LocalDate beginDate, LocalDate endDate, String applicationMethod, String contact, String supportDetail, String supportTarget, String requiredDocumentsRawText, List<String> requiredDocuments) {
        this.id = id;
        this.policyId = policyId;
        this.industryId = industryId;
        this.regionId = regionId;
        this.departmentName = departmentName;
        this.userType = userType;
        this.announcementUrl = announcementUrl;
        this.policyName = policyName;
        this.policySummary = policySummary;
        this.policyField = policyField;
        this.selectionCriteria = selectionCriteria;
        this.supervisingOrganizationName = supervisingOrganizationName;
        this.receivingOrganizationName = receivingOrganizationName;
        this.noticeDate = noticeDate;
        this.modificationDate = modificationDate;
        this.bookmarkCount = bookmarkCount;
        this.applicationPeriod = applicationPeriod;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.applicationMethod = applicationMethod;
        this.contact = contact;
        this.supportDetail = supportDetail;
        this.supportTarget = supportTarget;
        this.requiredDocumentsRawText = requiredDocumentsRawText;
        this.requiredDocuments = requiredDocuments;
    }

    public void parseAndSetRequiredDocuments() {
        if (this.requiredDocumentsRawText == null || this.requiredDocumentsRawText.isBlank()) {
            this.requiredDocuments = Collections.emptyList();
            return;
        }

        this.requiredDocuments = Arrays.stream(this.requiredDocumentsRawText.split("[,\r\n]+"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    public void updateDocuments(String rawDocumentsText, LocalDateTime updateTimestamp) {
        this.requiredDocumentsRawText = rawDocumentsText;
        this.modificationDate = updateTimestamp;
        // 새로운 텍스트를 기반으로 리스트를 다시 파싱합니다.
        this.parseAndSetRequiredDocuments();
    }
}