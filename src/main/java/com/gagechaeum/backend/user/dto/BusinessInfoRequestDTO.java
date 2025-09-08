package com.gagechaeum.backend.user.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BusinessInfoRequestDTO {

    Long regionId;
    Long industryId;
    String businessNum;
    String salesScope;
    String companyName;
    LocalDate estbDate;

    public BusinessInfoDTO toBusinessInfoDTO(Long userId) {
        return BusinessInfoDTO.builder()
                .userId(userId)
                .regionId(this.regionId)
                .industryId(this.industryId)
                .businessNum(this.businessNum)
                .salesScope(this.salesScope)
                .companyName(this.companyName)
                .estbDate(this.estbDate)
                .build();
    }
}
