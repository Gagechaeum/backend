package com.gagechaeum.backend.application.service;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import com.gagechaeum.backend.application.mapper.ApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationMapper applicationMapper;

    @Override
    public List<ApplicationResponseDTO> findApplicationsByUserId(Long userId) {

        List<ApplicationResponseDTO> applications = applicationMapper.findApplicationsByUserId(userId);

        // 진행률(%) 계산
        for (ApplicationResponseDTO dto : applications) {
            int progressPercentage;

            if (dto.getTotalDocsCount() > 0) {
                progressPercentage = (int) ((double) dto.getCompletedDocsCount() * 100 / dto.getTotalDocsCount());
            } else { // totalDocsCount가 0인 경우
                progressPercentage = 100;
            }
            dto.setProgressPercentage(progressPercentage);
        }

        return applications;
    }

    @Override
    @Transactional
    public void updateApplicationStatus(Long userId, String type, Long id, String status) {
        if ("policy".equalsIgnoreCase(type)) {
            applicationMapper.updateUserPolicyStatus(userId, id, status);
        } else if ("loan".equalsIgnoreCase(type)) {
            applicationMapper.updateUserLoanStatus(userId, id, status);
        } else {
            throw new IllegalArgumentException("Invalid application type: " + type);
        }
    }
}
