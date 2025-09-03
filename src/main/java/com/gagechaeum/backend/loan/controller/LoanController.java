package com.gagechaeum.backend.loan.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;
import com.gagechaeum.backend.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/recommendation")
    public CustomResponse<LoanRecommendationResponseDTO> recommendLoans(
            @RequestParam Long userId
    ) {
        LoanRecommendationResponseDTO response = loanService.getRecommendedLoans(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
    
    @GetMapping("/{loan_id}")
    public CustomResponse<Object> getLoanDetails(@PathVariable("loan_id") Long loanId) {
        Object response = loanService.getLoanDetails(loanId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}
