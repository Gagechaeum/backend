package com.gagechaeum.backend.application.mapper;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplicationMapper {

    // 신청 현황 조회
    List<ApplicationResponseDTO> findApplicationsByUserId(Long userId);

    // 정책 신청 상태 업데이트
    int updateUserPolicyStatus(@Param("userId") Long userId, @Param("id") Long id, @Param("status") String status);

    // 대출 신청 상태 업데이트
    int updateUserLoanStatus(@Param("userId") Long userId, @Param("id") Long id, @Param("status") String status);
}
