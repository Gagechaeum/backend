package com.gagechaeum.backend.report.service;

import com.gagechaeum.backend.report.dto.response.DashboardResponse;

public interface ReportService {
    DashboardResponse getDashboardData(Long userId);
}

