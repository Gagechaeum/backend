package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import com.gagechaeum.backend.user.dto.BusinessInfoDTO;
import com.gagechaeum.backend.user.dto.BusinessInfoRequestDTO;
import com.gagechaeum.backend.user.mapper.BusinessInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessInfoServiceImpl implements BusinessInfoService {
    final private BusinessInfoMapper businessInfoMapper;

    @Override
    public void save(Long userId, BusinessInfoRequestDTO reqDto) {
        BusinessInfoDTO dto = reqDto.toBusinessInfoDTO(userId);
        BusinessInfoVO vo = dto.toVO();
        businessInfoMapper.save(vo);
    }

    @Override
    public void update(BusinessInfoDTO reqDto) {
        BusinessInfoVO vo = reqDto.toVO();
        businessInfoMapper.update(vo);
    }

    @Override
    public void delete(Long businessInfoId) {
        businessInfoMapper.delete(businessInfoId);
    }

    @Override
    public List<BusinessInfoDTO> selectAll(Long userId) {
        List<BusinessInfoVO> bisVO=businessInfoMapper.selectByUserId(userId);

        return bisVO.stream()
                .map(BusinessInfoDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean verifyBusinessIdentity(Long business_num, String name, LocalDate date) {
        return null;
    }
}
