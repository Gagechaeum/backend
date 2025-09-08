package com.gagechaeum.backend.policy.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Gov24ApiDetailResponseDto {

    @JsonProperty("data")
    private List<DetailData> data;

    @Getter
    @NoArgsConstructor
    public static class DetailData {

        @JsonProperty("서비스ID")
        private String serviceId;

        @JsonProperty("구비서류")
        private String requiredDocumentsText;
    }
}
