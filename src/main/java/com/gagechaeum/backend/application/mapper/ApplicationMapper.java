package com.gagechaeum.backend.application.mapper;

import com.gagechaeum.backend.application.dto.response.ApplicationResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    List<ApplicationResponseDTO> findApplicationsByUserId(Long userId);
}
