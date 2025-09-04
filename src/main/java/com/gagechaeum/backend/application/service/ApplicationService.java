package com.gagechaeum.backend.application.service;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;

import java.util.List;

public interface ApplicationService {
    List<ApplicationResponseDTO> findApplicationsByUserId(Long userId);
}
