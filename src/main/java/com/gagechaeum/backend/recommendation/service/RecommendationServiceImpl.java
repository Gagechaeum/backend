package com.gagechaeum.backend.recommendation.service;

import com.gagechaeum.backend.recommendation.domain.Policy;
import com.gagechaeum.backend.recommendation.dto.response.PolicyInfoDTO;
import com.gagechaeum.backend.recommendation.dto.response.PolicyRecommendationResponseDTO;
import com.gagechaeum.backend.recommendation.mapper.RecommendationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationMapper recommendationMapper;

    @Override
    @Transactional(readOnly = true)
    public PolicyRecommendationResponseDTO getRecommendedPolicies(Long userId) {
        List<Policy> policies = recommendationMapper.findRecommendedPoliciesByUserId(userId);

        List<PolicyInfoDTO> policyInfos = policies.stream()
                .map(PolicyInfoDTO::from)
                .collect(Collectors.toList());

        return PolicyRecommendationResponseDTO.from(policyInfos);
    }
}
