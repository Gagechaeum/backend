package com.gagechaeum.backend.report.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.report.dto.response.DashboardResponse;
import com.gagechaeum.backend.report.service.ReportService;
// import com.gagechaeum.backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/dashboard")
    public ResponseEntity<CustomResponse<DashboardResponse>> getDashboardData(
            // @AuthenticationPrincipal UserDetailsImpl userDetails // 주석 해제 후 사용
    ) {
        // Long userId = userDetails.getUser().getId();
        Long userId = 1L; // 테스트용 임시 사용자 ID
        DashboardResponse dashboardData = reportService.getDashboardData(userId);

        // 알려주신 ResponseCode.SUCCESS를 사용하여 응답을 생성합니다.
        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS, dashboardData));
    }
}