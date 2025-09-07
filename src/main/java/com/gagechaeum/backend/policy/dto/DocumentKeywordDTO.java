package com.gagechaeum.backend.policy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DocumentKeywordDTO {
    private Long documentId;
    private String documentName;
    private String keywords;
}
