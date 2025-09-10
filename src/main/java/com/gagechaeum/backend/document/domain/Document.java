package com.gagechaeum.backend.document.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Document {
    private Long documentId;
    private String documentName;
    private String keywords;
}
