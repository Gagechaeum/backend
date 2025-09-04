package com.gagechaeum.backend.report.mapper;

import com.gagechaeum.backend.report.domain.PolicySearchResult;
import com.gagechaeum.backend.report.domain.Repayment;
import com.gagechaeum.backend.report.domain.UserLoan;
import com.gagechaeum.backend.report.domain.UserPolicy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    // 사용자의 모든 정책 정보 조회 (정책 테이블과 JOIN)
    List<UserPolicy> findUserPoliciesByUserId(@Param("userId") Long userId);

    // 사용자의 모든 대출 정보 조회
    List<UserLoan> findUserLoansByUserId(@Param("userId") Long userId);

    // 여러 대출 ID에 해당하는 상환 내역 조회
    List<Repayment> findRepaymentsByUserLoanIds(@Param("userLoanIds") List<Long> userLoanIds);

    // 정책 이름으로 정책 검색
    List<PolicySearchResult> searchPoliciesByName(@Param("keyword") String keyword);

    void insertUserPolicy(UserPolicy userPolicy);
}
