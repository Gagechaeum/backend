package com.gagechaeum.backend.bookmark.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDocumentsResponseDTO {

    private int totalBookmarkCount;
    private List<DocumentInfoDTO> documents;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DocumentInfoDTO {
        private String documentName;
        private int productCount;
        private String possessionStatus;
        private String issuingUrl;
    }
}
