package com.gagechaeum.backend.loan.service;

import com.gagechaeum.backend.loan.dto.response.LoanDetailResponseDto;
import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface LoanService {
    LoanRecommendationResponseDTO getRecommendedLoans(Long userId);
    
    LoanDetailResponseDto getLoanDetails(@PathVariable("loan_id") Long loanId);
}
