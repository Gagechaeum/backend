package com.gagechaeum.backend.loan.domain;

import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class Loan {
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
    private Long bookmarkCount;
}
