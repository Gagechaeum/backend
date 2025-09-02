package com.gagechaeum.backend.loan.dto.response;

import com.gagechaeum.backend.loan.domain.Loan;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class LoanInfoDTO {
    private Long loanId;
    private String loanName;
    private String loanSummary;
    private String organizationName;
    private BigDecimal interestRate;
    private Long loanLimit;

    public static LoanInfoDTO from(Loan loan) {
        return LoanInfoDTO.builder()
                .loanId(loan.getLoanId())
                .loanName(loan.getLoanName())
                .loanSummary(loan.getLoanSummary())
                .organizationName(loan.getOrganizationName())
                .interestRate(loan.getInterestRate())
                .loanLimit(loan.getLoanLimit())
                .build();
    }
}
