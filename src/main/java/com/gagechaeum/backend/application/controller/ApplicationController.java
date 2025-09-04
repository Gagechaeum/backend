package com.gagechaeum.backend.application.controller;

import com.gagechaeum.backend.application.dto.request.ApplicationStatusUpdateRequestDTO;
import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import com.gagechaeum.backend.application.service.ApplicationService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/me")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/applications")
    public CustomResponse<List<ApplicationResponseDTO>> getApplications() {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        List<ApplicationResponseDTO> applications = applicationService.findApplicationsByUserId(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, applications);
    }

    @PatchMapping("/policies/{id}/status")
    public CustomResponse<Void> updateUserPolicyStatus(
            @PathVariable Long id,
            @RequestBody ApplicationStatusUpdateRequestDTO request) {
        // TODO: 실제 사용자 ID 가져오기
        Long userId = 1L;
        applicationService.updateApplicationStatus(userId, "policy", id, request.getStatus());
        return CustomResponse.success(ResponseCode.SUCCESS, null);
    }

    @PatchMapping("/loans/{id}/status")
    public CustomResponse<Void> updateUserLoanStatus(
            @PathVariable Long id,
            @RequestBody ApplicationStatusUpdateRequestDTO request) {
        // TODO: 실제 사용자 ID 가져오기
        Long userId = 1L;
        applicationService.updateApplicationStatus(userId, "loan", id, request.getStatus());
        return CustomResponse.success(ResponseCode.SUCCESS, null);
    }
}
