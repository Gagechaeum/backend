package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.policy.domain.Regions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    List<Regions> findAll();
}