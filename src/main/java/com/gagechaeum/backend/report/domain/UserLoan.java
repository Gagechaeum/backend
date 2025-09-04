package com.gagechaeum.backend.report.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Mock 데이터 생성을 위해 Builder 사용
public class UserLoan {
    private Long userLoanId;
    private String productName;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private BigDecimal lastOfferedRate;
    private String repayMethod;
    private Long balanceAmount;
    private Long loanPrincipal;
    private LocalDate nextRepayDate;

    @Builder
    public UserLoan(Long userLoanId, String productName, LocalDate issueDate, LocalDate expiryDate, BigDecimal lastOfferedRate, String repayMethod, Long balanceAmount, Long loanPrincipal, LocalDate nextRepayDate) {
        this.userLoanId = userLoanId;
        this.productName = productName;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.lastOfferedRate = lastOfferedRate;
        this.repayMethod = repayMethod;
        this.balanceAmount = balanceAmount;
        this.loanPrincipal = loanPrincipal;
        this.nextRepayDate = nextRepayDate;
    }
}
