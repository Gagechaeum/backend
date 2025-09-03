package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.loan.dto.response.LoanDetailResponseDto;
import com.gagechaeum.backend.policy.domain.Policy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PolicyMapper {
    List<Policy> findRecommendedPoliciesByUserId(@Param("userId") Long userId);

    void saveOrUpdatePolicy(Policy policy);
    
    Policy getPolicyById(String loanId);
}