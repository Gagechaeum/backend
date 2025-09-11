package com.gagechaeum.backend.user.dto;

import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessInfoDTO {

    Long BusinessInfoId;
    Long userId;
    Long regionId;
    Long industryId;
    String businessNum;
    LocalDate estbDate;

    public BusinessInfoVO toVO() {
        BusinessInfoVO vo = new BusinessInfoVO();
        vo.setBusinessInfoId(this.BusinessInfoId);
        vo.setUserId(this.userId);
        vo.setRegionId(this.regionId);
        vo.setIndustryId(this.industryId);
        vo.setBusinessNum(this.businessNum);
        vo.setEstbDate(this.estbDate);
        return vo;
    }

    public static BusinessInfoDTO of(BusinessInfoVO vo) {
        return BusinessInfoDTO.builder()
                .BusinessInfoId(vo.getBusinessInfoId())
                .userId(vo.getUserId())
                .regionId(vo.getRegionId())
                .industryId(vo.getIndustryId())
                .businessNum(vo.getBusinessNum())
                .estbDate(vo.getEstbDate())
                .build();
    }
}
