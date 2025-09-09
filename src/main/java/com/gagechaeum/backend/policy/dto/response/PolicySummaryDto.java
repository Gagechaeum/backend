package com.gagechaeum.backend.policy.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PolicySummaryDto {
	private String policyId;					// 공고 ID
	private Long industryId;					// 업종 ID
	private Long regionId;						// 지역 ID
	private String policyName;					// 정책 이름
	private String supervisingOrganizationName;	// 소관기관명
	private LocalDateTime noticeDate;			// 등록일시
	private LocalDateTime modificationDate;		// 수정일시
	private LocalDate beginDate;				// 시작일자
	private LocalDate endDate;					// 마감일자
	private Long bookmarkCount;					// 즐겨찾기 수
}
