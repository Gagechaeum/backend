package com.gagechaeum.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyBisReqDTO {

    @JsonProperty("b_no")
    private String businessNumber;

    @JsonProperty("start_dt")
    private String startDate;


    @JsonProperty("p_nm")
    private String ownerName;
}
