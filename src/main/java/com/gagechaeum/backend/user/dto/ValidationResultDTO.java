package com.gagechaeum.backend.user.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResultDTO {
    @JsonProperty("b_no")
    private String businessNumber;

    @JsonProperty("valid")
    private String valid;

    @JsonProperty("valid_msg")
    private String validMsg;
}
