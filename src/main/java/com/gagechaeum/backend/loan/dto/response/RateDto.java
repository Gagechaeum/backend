package com.gagechaeum.backend.loan.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class RateDto {
	private Long rateId;
	private String rateType;
	private BigDecimal averageRate;
	private BigDecimal rateRange1;
	private BigDecimal rateRange2;
	private BigDecimal rateRange3;
	private BigDecimal rateRange4;
	private BigDecimal rateRange5;
	private BigDecimal rateRange6;
	private BigDecimal rateRange7;
	private BigDecimal rateRange8;
}
