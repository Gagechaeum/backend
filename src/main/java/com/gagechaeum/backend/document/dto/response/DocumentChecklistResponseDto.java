package com.gagechaeum.backend.document.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DocumentChecklistResponseDto {

    private String itemName;
    private String organization;
    private List<DocumentStatusDto> documents;

    public DocumentChecklistResponseDto(String itemName, String organization, List<DocumentStatusDto> documents) {
        this.itemName = itemName;
        this.organization = organization;
        this.documents = documents;
    }

    @Getter
    @NoArgsConstructor
    public static class DocumentStatusDto {
        private String documentName;
        private boolean completed;

        public DocumentStatusDto(String documentName, boolean completed) {
            this.documentName = documentName;
            this.completed = completed;
        }
    }
}
