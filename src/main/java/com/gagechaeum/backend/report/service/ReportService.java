package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.dto.request.UserPolicyCreateRequestDTO;
import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.dto.response.PolicySearchResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportService {
    DashboardResponseDTO getDashboardData(Long userId);

    DashboardResponseDTO.AllItemsPage getItems(Long userId, Pageable pageable);

    List<PolicySearchResponseDTO> searchPolicies(String keyword);

    void createUserPolicy(Long userId, UserPolicyCreateRequestDTO requestDTO);
}
