package com.gagechaeum.backend.report.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.report.dto.request.UserPolicyCreateRequestDTO;
import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.dto.response.PolicySearchResponseDTO;
import com.gagechaeum.backend.report.service.ReportService;
// import com.gagechaeum.backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/policies")
    public ResponseEntity<CustomResponse<Void>> createUserPolicy(
            // @AuthenticationPrincipal UserDetailsImpl userDetails, // 주석 해제 후 사용
            @RequestBody UserPolicyCreateRequestDTO requestDTO
    ) {
        // Long userId = userDetails.getUser().getId();
        Long userId = 1L; // 테스트용 임시 사용자 ID
        reportService.createUserPolicy(userId, requestDTO);
        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<CustomResponse<DashboardResponseDTO>> getDashboardData(
            // @AuthenticationPrincipal UserDetailsImpl userDetails // 주석 해제 후 사용
    ) {
        // Long userId = userDetails.getUser().getId();
        Long userId = 1L; // 테스트용 임시 사용자 ID
        DashboardResponseDTO dashboardData = reportService.getDashboardData(userId);

        // 알려주신 ResponseCode.SUCCESS를 사용하여 응답을 생성합니다.
        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS, dashboardData));
    }

    @GetMapping("/search")
    public CustomResponse<List<PolicySearchResponseDTO>> searchPolicies(
            @RequestParam String keyword
    ) {
        List<PolicySearchResponseDTO> response = reportService.searchPolicies(keyword);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }
}
