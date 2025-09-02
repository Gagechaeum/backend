package com.gagechaeum.backend.loan.domain;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class Loan {
    private Long loanId;
    private String loanName;
    private String loanSummary;
    private String organizationName;
    private BigDecimal interestRate;
    private Long loanLimit;
}
