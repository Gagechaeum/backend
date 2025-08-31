package com.gagechaeum.backend.recommendation.mapper;

import com.gagechaeum.backend.recommendation.domain.Policy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecommendationMapper {
    List<Policy> findRecommendedPoliciesByUserId(@Param("userId") Long userId);
}