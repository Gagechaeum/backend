package com.gagechaeum.backend.policy.dto.external;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Gov24ApiDetailResponseDto {
    private List<Gov24ApiDetailDto> data;
}
