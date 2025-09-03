package com.gagechaeum.backend.loan.mapper;

import com.gagechaeum.backend.loan.domain.Loan;
import com.gagechaeum.backend.loan.dto.response.LoanDetailResponseDto;
import com.gagechaeum.backend.loan.dto.response.RateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper {
    List<Loan> findRecommendedLoansByUserId(@Param("userId") Long userId);
    
    LoanDetailResponseDto getLoanById(Long loanId);
    
    List<RateDto> getRatesByLoanId(Long loanId);
}
