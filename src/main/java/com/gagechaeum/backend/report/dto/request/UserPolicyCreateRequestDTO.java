package com.gagechaeum.backend.report.dto.request;

import com.gagechaeum.backend.report.domain.UserPolicy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserPolicyCreateRequestDTO {
    private String policyId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate firstPaymentDate;
    private Integer monthlyAmount;
    private Integer totalAmount;

    public UserPolicy toEntity(Long userId) {
        return UserPolicy.builder()
                .userId(userId)
                .policyId(this.policyId)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .firstPaymentDate(this.firstPaymentDate)
                .monthlyAmount(this.monthlyAmount)
                .totalAmount(this.totalAmount)
                .build();
    }
}
