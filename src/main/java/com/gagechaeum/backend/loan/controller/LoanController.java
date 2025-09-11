package com.gagechaeum.backend.loan.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.loan.dto.request.LoanListRequestDto;
import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;
import com.gagechaeum.backend.loan.service.LoanService;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    
    @GetMapping("")
    public CustomResponse<Object> getLoanList(
        @ModelAttribute LoanListRequestDto requestDto
    ) {
        Object response = loanService.getLoanList(requestDto);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/recommendation")
    public CustomResponse<LoanRecommendationResponseDTO> recommendLoans(
            @RequestParam Long userId
    ) {
        LoanRecommendationResponseDTO response = loanService.getRecommendedLoans(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @PostMapping ("/mydata")
    public CustomResponse<Void> linkLoans(@AuthenticationPrincipal CustomUserDetails userDetails) {
        loanService.linkLoan(userDetails.getUserId());
        return CustomResponse.success(ResponseCode.SUCCESS);
    }

    @GetMapping("/{loan_id}")
    public CustomResponse<Object> getLoanDetails(@PathVariable("loan_id") Long loanId) {
        Object response = loanService.getLoanDetails(loanId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}
