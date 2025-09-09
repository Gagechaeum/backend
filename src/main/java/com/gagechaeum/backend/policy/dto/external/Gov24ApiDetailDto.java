package com.gagechaeum.backend.policy.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Gov24ApiDetailDto {

    @JsonProperty("서비스ID")
    private String serviceId;

    @JsonProperty("구비서류")
    private String requiredDocuments;
}
