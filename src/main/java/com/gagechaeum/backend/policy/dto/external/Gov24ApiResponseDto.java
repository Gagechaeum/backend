package com.gagechaeum.backend.policy.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Gov24ApiResponseDto {

    @JsonProperty("currentCount")
    private int currentCount;

    @JsonProperty("data")
    private List<Gov24ApiServiceDto> data;

    @JsonProperty("matchCount")
    private int matchCount;

    @JsonProperty("page")
    private int page;

    @JsonProperty("perPage")
    private int perPage;

    @JsonProperty("totalCount")
    private int totalCount;
}
