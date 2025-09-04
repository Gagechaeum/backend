package com.gagechaeum.backend.loan.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LoanRecommendationResponseDTO {
    private List<LoanInfoDTO> loans;

    public static LoanRecommendationResponseDTO from(List<LoanInfoDTO> loans) {
        return LoanRecommendationResponseDTO.builder()
                .loans(loans)
                .build();
    }
}
