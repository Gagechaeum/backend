package com.gagechaeum.backend.user.dto;

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

    private List<VerifyBisReqDTO> businesses;


}
