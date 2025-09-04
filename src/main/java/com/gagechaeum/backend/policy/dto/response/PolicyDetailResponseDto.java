package com.gagechaeum.backend.policy.dto.response;

import com.gagechaeum.backend.policy.domain.Policy;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PolicyDetailResponseDto {
	private String policyId;                    // 공고 ID
	private Long industryId;					// 업종 ID
	private Long regionId;						// 지역 ID
	private String departmentName;              // 부서명
	private String userType;                    // 사용자 구분("법인/시설/단체", "개인" 등)
	private String announcementUrl;				// 공고 URL
	private String policyName;                  // 정책 이름
	private String policySummary;               // 정책 개요
	private String policyField;                 // 정책 분야("생활안정", "고용·창업" 등)
	private String selectionCriteria;           // 선정 기준
	private String supervisingOrganizationName; // 소관기관명
	private String receivingOrganizationName;   // 접수기관명
	private LocalDateTime noticeDate;           // 등록일시
	private LocalDateTime modificationDate;     // 수정일시
	private String applicationPeriod;			// 신청기간
	private LocalDate beginDate;                // 시작일자
	private LocalDate endDate;                  // 마감일자
	private String applicationMethod;           // 신청 방법
	private String contact;                     // 문의 연락처
	private String supportDetail;               // 지원 내용
	private String supportTarget;               // 지원 대상
	
	public static PolicyDetailResponseDto fromVo(Policy policy) {
		return PolicyDetailResponseDto
			.builder()
			.policyId(policy.getPolicyId())
			.industryId(policy.getIndustryId())
			.regionId(policy.getRegionId())
			.departmentName(policy.getDepartmentName())
			.userType(policy.getUserType())
			.announcementUrl(policy.getAnnouncementUrl())
			.policyName(policy.getPolicyName())
			.policySummary(policy.getPolicySummary())
			.policyField(policy.getPolicyField())
			.selectionCriteria(policy.getSelectionCriteria())
			.supervisingOrganizationName(policy.getSupervisingOrganizationName())
			.receivingOrganizationName(policy.getReceivingOrganizationName())
			.noticeDate(policy.getNoticeDate())
			.modificationDate(policy.getModificationDate())
			.applicationPeriod(policy.getApplicationPeriod())
			.beginDate(policy.getBeginDate())
			.endDate(policy.getEndDate())
			.applicationMethod(policy.getApplicationMethod())
			.contact(policy.getContact())
			.supportDetail(policy.getSupportDetail())
			.supportTarget(policy.getSupportTarget())
			.build();
	}
}