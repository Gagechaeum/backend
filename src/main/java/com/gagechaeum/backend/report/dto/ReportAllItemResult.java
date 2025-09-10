package com.gagechaeum.backend.report.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReportAllItemResult {
    private String type; // "POLICY" 또는 "LOAN"
    private Long itemId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long amount;
    private String amountLabel;

    // LOAN 전용 필드
    private String repaymentMethod;
    private BigDecimal repaymentRate; // 계산은 서비스에서 수행하거나 복잡한 쿼리로 처리
    private BigDecimal interestRate;

    // POLICY 전용 필드
    private Integer paymentDay; // 매월 지급일
    private Long totalBenefitAmount;
}
