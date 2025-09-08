package com.gagechaeum.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyBisResDTO {

    private List<ValidationResultDTO> data;
}
