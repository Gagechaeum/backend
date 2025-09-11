package com.gagechaeum.backend.loan.service;

import com.gagechaeum.backend.loan.dto.request.LoanListRequestDto;
import com.gagechaeum.backend.loan.dto.response.LoanDetailResponseDto;
import com.gagechaeum.backend.loan.dto.response.LoanListResponseDto;
import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;

public interface LoanService {
    LoanListResponseDto getLoanList(LoanListRequestDto requestDto);
    
    LoanRecommendationResponseDTO getRecommendedLoans(Long userId);
    
    LoanDetailResponseDto getLoanDetails(Long loanId);

    void linkLoan(Long userId);
}
