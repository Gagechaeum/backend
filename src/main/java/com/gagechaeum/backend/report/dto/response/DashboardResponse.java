package com.gagechaeum.backend.report.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class DashboardResponse {

    private Summary summary;
    private List<Schedule> schedule;
    private List<CashFlow> cashFlow;
    private List<AllItem> allItems;

    @Getter
    @Builder
    public static class Summary {
        private long totalBenefitAmount;
        private long totalRepaymentAmount;
    }

    @Getter
    @Builder
    public static class Schedule {
        private String type; // "BENEFIT" or "REPAYMENT"
        private String name;
        private LocalDate date;
        private long amount;
    }

    @Getter
    @Builder
    public static class CashFlow {
        private String month;
        private long benefit;
        private long repayment;
    }

    @Getter
    @Builder
    public static class AllItem {
        private String type; // "LOAN" or "POLICY"
        private Long itemId;
        private String name;
        private String period;
        private long amount;
        private String amountLabel;
        private String status;
        private Details details;
    }

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Details {
        // Policy Details
        private String paymentDateInfo;
        private Long totalBenefitAmount;

        // Loan Details
        private String repaymentMethod;
        private BigDecimal repaymentRate;
        private BigDecimal interestRate;
    }
}
