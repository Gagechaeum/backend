package com.gagechaeum.backend.loan.dto.response;

import com.gagechaeum.backend.loan.domain.Loan;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class LoanInfoDTO {
    private Long loanId;
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

    public static LoanInfoDTO from(Loan loan) {
        return LoanInfoDTO.builder()
                .loanId(loan.getLoanId())
                .companyName(loan.getCompanyName())
                .productName(loan.getProductName())
                .joinWay(loan.getJoinWay())
                .beginDate(loan.getBeginDate())
                .endDate(loan.getEndDate())
                .productPageUrl(loan.getProductPageUrl())
                .minLimit(loan.getMinLimit())
                .maxLimit(loan.getMaxLimit())
                .basicRate(loan.getBasicRate())
                .bookmarkCount(loan.getBookmarkCount())
                .build();
    }
}
