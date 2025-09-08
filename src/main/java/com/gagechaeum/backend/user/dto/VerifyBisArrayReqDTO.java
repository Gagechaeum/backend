package com.gagechaeum.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyBisArrayReqDTO {

    @JsonProperty("businesses")
    private List<VerifyBisReqDTO> businesses;



}
