package com.gagechaeum.backend.loan.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class LoanDetailResponseDto {
	private Long loanId;
	private Long industryId;
	private Long regionId;
	private String companyName;
	private String productName;
	private String joinWay;
	private LocalDate beginDate;
	private LocalDate endDate;
	private String productPageUrl;
	private Long minLimit;
	private Long maxLimit;
	private BigDecimal basicRate;
	private List<RateDto> rateByCredit;
}
