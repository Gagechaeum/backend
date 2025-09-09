package com.gagechaeum.backend.document.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RequiredDocument {
    private Long requiredDocumentId;
    private Long documentId;
    private String policyId;

    @Builder
    public RequiredDocument(Long documentId, String policyId) {
        this.documentId = documentId;
        this.policyId = policyId;
    }
}
