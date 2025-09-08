package com.gagechaeum.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class VerifyBisResDTO {
    private List<ValidationResultDTO> data;
}
