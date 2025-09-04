package com.gagechaeum.backend.application.service;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;

import java.util.List;

public interface ApplicationService {

    // 신청 현황 조회
    List<ApplicationResponseDTO> findApplicationsByUserId(Long userId);

    // 신청 상태 업데이트
    void updateApplicationStatus(Long userId, String type, Long id, String status);
}
