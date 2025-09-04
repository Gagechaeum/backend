package com.gagechaeum.backend.application.controller;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import com.gagechaeum.backend.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/me/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationResponseDTO>> getApplications() {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        List<ApplicationResponseDTO> applications = applicationService.findApplicationsByUserId(userId);
        return ResponseEntity.ok(applications);
    }
}
