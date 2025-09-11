package com.gagechaeum.backend.report.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.report.dto.request.UserPolicyCreateRequestDTO;
import com.gagechaeum.backend.report.dto.response.DashboardResponseDTO;
import com.gagechaeum.backend.report.dto.response.PolicySearchResponseDTO;
import com.gagechaeum.backend.report.service.ReportService;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody UserPolicyCreateRequestDTO requestDTO
    ) {
        Long userId = user.getUserId();
        reportService.createUserPolicy(userId, requestDTO);
        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<CustomResponse<DashboardResponseDTO>> getDashboardData(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        Long userId = user.getUserId();
        DashboardResponseDTO dashboardData = reportService.getDashboardData(userId);

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SUCCESS, dashboardData));
    }

    @GetMapping("/items")
    public CustomResponse<DashboardResponseDTO.AllItemsPage> getItems(
            @AuthenticationPrincipal CustomUserDetails user,
            @PageableDefault(size = 5) Pageable pageable) {
        Long userId = user.getUserId();
        DashboardResponseDTO.AllItemsPage items = reportService.getItems(userId, pageable);
        return CustomResponse.success(ResponseCode.SUCCESS, items);
    }

    @GetMapping("/search")
    public CustomResponse<List<PolicySearchResponseDTO>> searchPolicies(
            @RequestParam String keyword
    ) {
        List<PolicySearchResponseDTO> response = reportService.searchPolicies(keyword);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @GetMapping("/mydata")
    public CustomResponse<Void> linkRepayment(@AuthenticationPrincipal CustomUserDetails userDetails) {
        reportService.linkRepayment(userDetails.getUserId());
        return CustomResponse.success(ResponseCode.SUCCESS);
    }
}
