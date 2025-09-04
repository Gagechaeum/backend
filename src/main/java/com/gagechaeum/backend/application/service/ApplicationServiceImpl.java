package com.gagechaeum.backend.application.service;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import com.gagechaeum.backend.application.mapper.ApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
            int progressPercentage = 0;
            // 0으로 나누는 것을 방지
            if (dto.getTotalDocsCount() > 0) {
                progressPercentage = (int) ((double) dto.getCompletedDocsCount() * 100 / dto.getTotalDocsCount());
            } else if (dto.getTotalDocsCount() == 0) {
                // 필요한 서류가 0개인 경우 100%로 처리
                progressPercentage = 100;
            }
            dto.setProgressPercentage(progressPercentage);
        }

        return applications;
    }
}
