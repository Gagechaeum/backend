package com.gagechaeum.backend.loan.mapper;

import com.gagechaeum.backend.loan.domain.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper {
    List<Loan> findRecommendedLoansByUserId(@Param("userId") Long userId);
}
