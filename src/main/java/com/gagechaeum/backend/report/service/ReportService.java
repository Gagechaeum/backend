package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.dto.response.PolicySearchResponseDTO;

import java.util.List;

public interface ReportService {
    DashboardResponseDTO getDashboardData(Long userId);

    List<PolicySearchResponseDTO> searchPolicies(String keyword);
}