package com.gagechaeum.backend.user.domain;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class BusinessInfoVO {

    Long BusinessInfoId;
    Long userId;
    Long regionId;
    Long industryId;
    String businessNum;
    String salesScope;
    String companyName;
    LocalDate estbDate;
}
