package com.gagechaeum.backend.loan.mapper;

import com.gagechaeum.backend.loan.domain.Loan;
import com.gagechaeum.backend.loan.dto.request.LoanListRequestDto;
import com.gagechaeum.backend.loan.dto.response.LoanDetailResponseDto;
import com.gagechaeum.backend.loan.dto.response.LoanSummaryDto;
import com.gagechaeum.backend.loan.dto.response.RateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper {
    List<LoanSummaryDto> getLoanList(@Param("requestDto") LoanListRequestDto requestDto);
    
    List<Loan> findRecommendedLoansByUserId(@Param("userId") Long userId);
    
    LoanDetailResponseDto getLoanById(@Param("loanId") Long loanId);
    
    List<RateDto> getRatesByLoanId(@Param("loanId") Long loanId);
}
