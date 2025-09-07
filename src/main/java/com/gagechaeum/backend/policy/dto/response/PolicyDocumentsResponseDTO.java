package com.gagechaeum.backend.policy.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PolicyDocumentsResponseDTO {

    private List<StructuredDocumentDTO> structuredDocuments;
    private String unstructuredDocumentText;

    @Getter
    @Builder
    public static class StructuredDocumentDTO {
        private String documentName;
        private String possessionStatus;
        private String issuingUrl;
    }
}
