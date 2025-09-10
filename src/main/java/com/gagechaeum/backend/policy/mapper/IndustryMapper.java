package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.policy.domain.Industry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustryMapper {
    List<Industry> findAll();
}