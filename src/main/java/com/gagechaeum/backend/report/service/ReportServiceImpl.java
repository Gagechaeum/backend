package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.domain.Repayment;
import com.gagechaeum.backend.report.domain.UserLoan;
import com.gagechaeum.backend.report.domain.UserPolicy;
import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    @Override
    @Transactional(readOnly = true)
    public DashboardResponseDTO getDashboardData(Long userId) {
        // --- 1. 데이터 조회 ---
        List<UserPolicy> userPolicies = reportMapper.findUserPoliciesByUserId(userId);

        // [중요] 마이데이터 연동 여부 플래그
        boolean isMyDataReady = false;

        List<UserLoan> userLoans;
        List<Repayment> repayments;

        if (isMyDataReady) {
            userLoans = reportMapper.findUserLoansByUserId(userId);
            if (userLoans.isEmpty()) {
                repayments = Collections.emptyList();
            } else {
                List<Long> userLoanIds = userLoans.stream().map(UserLoan::getUserLoanId).collect(Collectors.toList());
                repayments = reportMapper.findRepaymentsByUserLoanIds(userLoanIds);
            }
        } else {
            userLoans = createMockUserLoans();
            repayments = createMockRepayments();
        }

        // --- 2. 데이터 가공 ---
        LocalDate now = LocalDate.now();

        DashboardResponseDTO.Summary summary = calculateSummary(userPolicies, repayments, now);
        List<DashboardResponseDTO.Schedule> schedule = createSchedule(userPolicies, userLoans, now);
        List<DashboardResponseDTO.CashFlow> cashFlow = createCashFlow(userPolicies, repayments, now);
        List<DashboardResponseDTO.AllItem> allItems = createAllItems(userPolicies, userLoans);

        // --- 3. 최종 DTO 조립 및 반환 ---
        return DashboardResponseDTO.builder()
                .summary(summary)
                .schedule(schedule)
                .cashFlow(cashFlow)
                .allItems(allItems)
                .build();
    }

    // --- 섹션별 계산 메서드 (이하 로직은 이전과 거의 동일) ---

    private DashboardResponseDTO.Summary calculateSummary(List<UserPolicy> policies, List<Repayment> repayments, LocalDate now) {
        YearMonth currentMonth = YearMonth.from(now);

        long benefit = policies.stream()
                .filter(p -> p.getDepositDate() != null && YearMonth.from(p.getDepositDate()).equals(currentMonth))
                .mapToLong(UserPolicy::getApprovedAmount)
                .sum();

        long repayment = repayments.stream()
                .filter(r -> r.getPaidDate() != null && YearMonth.from(r.getPaidDate()).equals(currentMonth))
                .mapToLong(Repayment::getAmount)
                .sum();

        return DashboardResponseDTO.Summary.builder()
                .totalBenefitAmount(benefit)
                .totalRepaymentAmount(repayment)
                .build();
    }

    private List<DashboardResponseDTO.Schedule> createSchedule(List<UserPolicy> policies, List<UserLoan> loans, LocalDate now) {
        LocalDate twoWeeksLater = now.plusWeeks(2);

        Stream<DashboardResponseDTO.Schedule> benefitStream = policies.stream()
                .filter(p -> p.getDepositDate() != null && !p.getDepositDate().isBefore(now) && p.getDepositDate().isBefore(twoWeeksLater))
                .map(p -> DashboardResponseDTO.Schedule.builder()
                        .type("BENEFIT")
                        .name(p.getPolicyName())
                        .date(p.getDepositDate())
                        .amount(p.getApprovedAmount())
                        .build());

        Stream<DashboardResponseDTO.Schedule> repaymentStream = loans.stream()
                .filter(l -> l.getNextRepayDate() != null && !l.getNextRepayDate().isBefore(now) && l.getNextRepayDate().isBefore(twoWeeksLater))
                .map(l -> DashboardResponseDTO.Schedule.builder()
                        .type("REPAYMENT")
                        .name(l.getProductName())
                        .date(l.getNextRepayDate())
                        .amount(850000) // Mock 상환 금액
                        .build());

        return Stream.concat(benefitStream, repaymentStream)
                .sorted(Comparator.comparing(DashboardResponseDTO.Schedule::getDate))
                .collect(Collectors.toList());
    }

    private List<DashboardResponseDTO.CashFlow> createCashFlow(List<UserPolicy> policies, List<Repayment> repayments, LocalDate now) {
        List<DashboardResponseDTO.CashFlow> cashFlowList = new ArrayList<>();
        YearMonth startMonth = YearMonth.from(now).minusMonths(5);

        Map<YearMonth, Long> monthlyBenefits = policies.stream()
                .filter(p -> p.getDepositDate() != null)
                .collect(Collectors.groupingBy(p -> YearMonth.from(p.getDepositDate()), Collectors.summingLong(UserPolicy::getApprovedAmount)));

        Map<YearMonth, Long> monthlyRepayments = repayments.stream()
                .filter(r -> r.getPaidDate() != null)
                .collect(Collectors.groupingBy(r -> YearMonth.from(r.getPaidDate()), Collectors.summingLong(Repayment::getAmount)));

        for (int i = 0; i < 6; i++) {
            YearMonth currentMonth = startMonth.plusMonths(i);
            long benefit = monthlyBenefits.getOrDefault(currentMonth, 0L);
            long repayment = monthlyRepayments.getOrDefault(currentMonth, 0L);

            cashFlowList.add(DashboardResponseDTO.CashFlow.builder()
                    .month(String.valueOf(currentMonth.getMonthValue()))
                    .benefit(benefit)
                    .repayment(repayment)
                    .build());
        }
        return cashFlowList;
    }

    private List<DashboardResponseDTO.AllItem> createAllItems(List<UserPolicy> policies, List<UserLoan> loans) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        Stream<DashboardResponseDTO.AllItem> policyStream = policies.stream()
                .map(p -> {
                    DashboardResponseDTO.Details details = DashboardResponseDTO.Details.builder()
                            .paymentDateInfo(p.getDepositDate() != null ? "매월 " + p.getDepositDate().getDayOfMonth() + "일" : "지급일 정보 없음")
                            .totalBenefitAmount(p.getApprovedAmount() * 12) // 총 지원금 계산 로직 필요
                            .build();

                    return DashboardResponseDTO.AllItem.builder()
                            .type("POLICY")
                            .itemId(p.getUserPolicyId())
                            .name(p.getPolicyName())
                            .period(p.getPolicyBeginDate().format(formatter) + " ~ " + p.getPolicyEndDate().format(formatter))
                            .amount(p.getApprovedAmount())
                            .amountLabel("월")
                            .status("진행중")
                            .details(details)
                            .build();
                });

        Stream<DashboardResponseDTO.AllItem> loanStream = loans.stream()
                .map(l -> {
                    BigDecimal repaymentRate = BigDecimal.ONE
                            .subtract(new BigDecimal(l.getBalanceAmount()).divide(new BigDecimal(l.getLoanPrincipal()), 4, RoundingMode.HALF_UP));

                    DashboardResponseDTO.Details details = DashboardResponseDTO.Details.builder()
                            .repaymentMethod(l.getRepayMethod())
                            .repaymentRate(repaymentRate)
                            .interestRate(l.getLastOfferedRate())
                            .build();

                    return DashboardResponseDTO.AllItem.builder()
                            .type("LOAN")
                            .itemId(l.getUserLoanId())
                            .name(l.getProductName())
                            .period(l.getIssueDate().format(formatter) + " ~ " + l.getExpiryDate().format(formatter))
                            .amount(l.getBalanceAmount())
                            .amountLabel("잔액")
                            .status("진행중")
                            .details(details)
                            .build();
                });

        return Stream.concat(policyStream, loanStream)
                .sorted(Comparator.comparing(DashboardResponseDTO.AllItem::getItemId))
                .collect(Collectors.toList());
    }

    // --- Mock 데이터 생성 메서드 ---

    private List<UserLoan> createMockUserLoans() {
        return List.of(
                UserLoan.builder()
                        .userLoanId(101L)
                        .productName("주택담보대출")
                        .issueDate(LocalDate.of(2023, 6, 1))
                        .expiryDate(LocalDate.of(2033, 5, 31))
                        .balanceAmount(170000000L)
                        .loanPrincipal(200000000L)
                        .repayMethod("분할상환")
                        .lastOfferedRate(new BigDecimal("3.5"))
                        .nextRepayDate(LocalDate.now().withDayOfMonth(10))
                        .build()
        );
    }

    private List<Repayment> createMockRepayments() {
        List<Repayment> mockRepayments = new ArrayList<>();
        // 최근 6개월간의 Mock 상환 데이터 생성
        for(int i=0; i<6; i++) {
            mockRepayments.add(Repayment.builder()
                    .repaymentId(201L + i)
                    .userLoanId(101L)
                    .paidDate(LocalDate.now().minusMonths(i).withDayOfMonth(10))
                    .amount(850000)
                    .build());
        }
        return mockRepayments;
    }
}