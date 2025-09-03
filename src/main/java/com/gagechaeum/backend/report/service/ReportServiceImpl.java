package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.domain.PolicySearchResult;
import com.gagechaeum.backend.report.domain.Repayment;
import com.gagechaeum.backend.report.domain.UserLoan;
import com.gagechaeum.backend.report.domain.UserPolicy;
import com.gagechaeum.backend.report.dto.request.UserPolicyCreateRequestDTO;
import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.dto.response.PolicySearchResponseDTO;
import com.gagechaeum.backend.report.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    @Transactional
    public void createUserPolicy(Long userId, UserPolicyCreateRequestDTO requestDTO) {
        reportMapper.insertUserPolicy(requestDTO.toEntity(userId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PolicySearchResponseDTO> searchPolicies(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<PolicySearchResult> searchResults = reportMapper.searchPoliciesByName(keyword);
        return searchResults.stream()
                .map(PolicySearchResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DashboardResponseDTO getDashboardData(Long userId) {
        // --- 1. 데이터 조회 ---
        List<UserPolicy> userPolicies = reportMapper.findUserPoliciesByUserId(userId);

        List<UserLoan> userLoans = reportMapper.findUserLoansByUserId(userId);
        List<Repayment> repayments;
        if (userLoans.isEmpty()) {
            repayments = Collections.emptyList();
        } else {
            List<Long> userLoanIds = userLoans.stream().map(UserLoan::getUserLoanId).collect(Collectors.toList());
            repayments = reportMapper.findRepaymentsByUserLoanIds(userLoanIds);
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

    // --- 섹션별 계산 메서드 ---

    private DashboardResponseDTO.Summary calculateSummary(List<UserPolicy> policies, List<Repayment> repayments, LocalDate now) {
        YearMonth currentMonth = YearMonth.from(now);

        long benefit = policies.stream()
                .filter(p -> p.getFirstPaymentDate() != null && YearMonth.from(p.getFirstPaymentDate()).equals(currentMonth))
                .mapToLong(UserPolicy::getMonthlyAmount)
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
                .filter(p -> p.getFirstPaymentDate() != null && !p.getFirstPaymentDate().isBefore(now) && p.getFirstPaymentDate().isBefore(twoWeeksLater))
                .map(p -> DashboardResponseDTO.Schedule.builder()
                        .type("BENEFIT")
                        .name(p.getPolicyName())
                        .date(p.getFirstPaymentDate())
                        .amount(p.getMonthlyAmount())
                        .build());

        Stream<DashboardResponseDTO.Schedule> repaymentStream = loans.stream()
                .filter(l -> l.getNextRepayDate() != null && !l.getNextRepayDate().isBefore(now) && l.getNextRepayDate().isBefore(twoWeeksLater))
                .map(l -> {
                    long principalAmount = 0; // 상환 원금
                    long interestAmount = 0;  // 납부 이자

                    // 1. 매월 납부할 이자 계산 (공통)
                    if (l.getBalanceAmount() > 0 && l.getLastOfferedRate() != null && l.getLastOfferedRate().compareTo(BigDecimal.ZERO) > 0) {
                        BigDecimal monthlyInterest = new BigDecimal(l.getBalanceAmount())
                                .multiply(l.getLastOfferedRate())
                                .divide(new BigDecimal("1200"), 0, RoundingMode.DOWN); // (잔액 * 연이율/100) / 12
                        interestAmount = monthlyInterest.longValue();
                    }

                    // 2. 상환 방식에 따른 원금 계산
                    if ("원금균등분할상환".equals(l.getRepayMethod())) {
                        long monthsBetween = ChronoUnit.MONTHS.between(l.getIssueDate(), l.getExpiryDate());
                        if (monthsBetween > 0) {
                            principalAmount = l.getLoanPrincipal() / monthsBetween;
                        }
                    } else if ("만기일시상환".equals(l.getRepayMethod())) {
                        // 다음 상환일이 만기일과 같다면 원금 전체를 상환
                        if (l.getNextRepayDate().isEqual(l.getExpiryDate())) {
                            principalAmount = l.getBalanceAmount();
                        }
                    }

                    // 3. 최종 납부 금액 = 원금 + 이자
                    long totalAmount = principalAmount + interestAmount;

                    return DashboardResponseDTO.Schedule.builder()
                            .type("REPAYMENT")
                            .name(l.getProductName())
                            .date(l.getNextRepayDate())
                            .amount(totalAmount)
                            .build();
                });

        return Stream.concat(benefitStream, repaymentStream)
                .sorted(Comparator.comparing(DashboardResponseDTO.Schedule::getDate))
                .collect(Collectors.toList());
    }

    private List<DashboardResponseDTO.CashFlow> createCashFlow(List<UserPolicy> policies, List<Repayment> repayments, LocalDate now) {
        List<DashboardResponseDTO.CashFlow> cashFlowList = new ArrayList<>();
        YearMonth startMonth = YearMonth.from(now).minusMonths(5);

        Map<YearMonth, Long> monthlyBenefits = policies.stream()
                .filter(p -> p.getFirstPaymentDate() != null)
                .collect(Collectors.groupingBy(p -> YearMonth.from(p.getFirstPaymentDate()), Collectors.summingLong(UserPolicy::getMonthlyAmount)));

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
                            .paymentDateInfo(p.getFirstPaymentDate() != null ? "매월 " + p.getFirstPaymentDate().getDayOfMonth() + "일" : "지급일 정보 없음")
                            .totalBenefitAmount(p.getTotalAmount().longValue())
                            .build();

                    return DashboardResponseDTO.AllItem.builder()
                            .type("POLICY")
                            .itemId(p.getUserPolicyId())
                            .name(p.getPolicyName())
                            .period(p.getStartDate().format(formatter) + " ~ " + p.getEndDate().format(formatter))
                            .amount(p.getMonthlyAmount())
                            .amountLabel("월")
                            .status("진행중")
                            .details(details)
                            .build();
                });

        Stream<DashboardResponseDTO.AllItem> loanStream = loans.stream()
                .map(l -> {
                    BigDecimal repaymentRate;
                    if (l.getLoanPrincipal() > 0) {
                        repaymentRate = BigDecimal.ONE
                                .subtract(new BigDecimal(l.getBalanceAmount()).divide(new BigDecimal(l.getLoanPrincipal()), 4, RoundingMode.HALF_UP));
                    } else {
                        repaymentRate = BigDecimal.ZERO;
                    }


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
}