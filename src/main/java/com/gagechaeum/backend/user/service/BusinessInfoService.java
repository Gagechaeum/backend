package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import com.gagechaeum.backend.user.dto.BusinessInfoDTO;
import com.gagechaeum.backend.user.dto.BusinessInfoRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface BusinessInfoService {
    void save(Long userId,BusinessInfoRequestDTO reqDto);
    void update(BusinessInfoDTO reqDto);
    void delete(Long businessInfoId);
    List<BusinessInfoDTO> selectAll(Long userId);

    //사업자 번호, 유저명, 개업일자가 일치하는지 검증하는 기능
    Boolean verifyBusinessInfo(Long business_num, String name, LocalDate date);
}
