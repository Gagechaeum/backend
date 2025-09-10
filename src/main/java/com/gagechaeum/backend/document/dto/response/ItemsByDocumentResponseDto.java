package com.gagechaeum.backend.document.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsByDocumentResponseDto {

    private String name;
    private String type;
    private String organization;
    private Long dDay;
    private String documentStatus;

    public ItemsByDocumentResponseDto(String name, String type, String organization, Long dDay, Long prepared, Long required) {
        this.name = name;
        this.type = type;
        this.organization = organization;
        this.dDay = dDay;
        this.documentStatus = (prepared != null ? prepared : 0) + "/" + (required != null ? required : 0);
    }
}