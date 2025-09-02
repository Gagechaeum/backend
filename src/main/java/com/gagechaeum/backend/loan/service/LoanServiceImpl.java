package com.gagechaeum.backend.loan.service;

import com.gagechaeum.backend.loan.domain.Loan;
import com.gagechaeum.backend.loan.dto.response.LoanInfoDTO;
import com.gagechaeum.backend.loan.dto.response.LoanRecommendationResponseDTO;
import com.gagechaeum.backend.loan.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanMapper loanMapper;

    @Override
    @Transactional(readOnly = true)
    public LoanRecommendationResponseDTO getRecommendedLoans(Long userId) {
        List<Loan> loans = loanMapper.findRecommendedLoansByUserId(userId);

        List<LoanInfoDTO> loanInfos = loans.stream()
                .map(LoanInfoDTO::from)
                .collect(Collectors.toList());

        return LoanRecommendationResponseDTO.from(loanInfos);
    }
}
