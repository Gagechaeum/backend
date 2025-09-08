package com.gagechaeum.backend.loan.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class LoanSummaryDto {
	private Long loanId;			// 상품 ID
	private Long industryId;		// 업종 ID
	private Long regionId;			// 지역 ID
	private String companyName;		// 금융회사명
	private String productName;		// 상품명
	private LocalDate beginDate;	// 공시 시작일
	private LocalDate endDate;		// 공시 종료일
	private Long minLimit;			// 최소 한도
	private Long maxLimit;			// 최대 한도
	private BigDecimal minRate;		// 최저 금리
	private BigDecimal maxRate;		// 최대 금리
	private BigDecimal basicRate;	// 기본 금리
	private Long bookmarkCount;		// 즐겨찾기 수
}
