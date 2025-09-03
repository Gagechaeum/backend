package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;

public interface ReportService {
    DashboardResponseDTO getDashboardData(Long userId);
}

