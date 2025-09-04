package com.gagechaeum.backend.report.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Repayment {
    private Long repaymentId;
    private Long userLoanId;
    private long amount;
    private LocalDate paidDate;

    @Builder
    public Repayment(Long repaymentId, Long userLoanId, long amount, LocalDate paidDate) {
        this.repaymentId = repaymentId;
        this.userLoanId = userLoanId;
        this.amount = amount;
        this.paidDate = paidDate;
    }
}