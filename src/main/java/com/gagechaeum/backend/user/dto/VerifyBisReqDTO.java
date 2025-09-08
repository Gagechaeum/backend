package com.gagechaeum.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerifyBisReqDTO {
    private String businessNumber;

    private String startDate;

    private String ownerName;
}
