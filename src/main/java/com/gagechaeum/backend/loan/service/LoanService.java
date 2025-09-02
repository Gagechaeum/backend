package com.gagechaeum.backend.loan.service;

import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;

public interface LoanService {
    LoanRecommendationResponseDTO getRecommendedLoans(Long userId);
}
