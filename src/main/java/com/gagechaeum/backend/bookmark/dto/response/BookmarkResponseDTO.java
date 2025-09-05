package com.gagechaeum.backend.bookmark.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkResponseDTO {
    private String bookmarkId;
    private String processStage;
    private String productType;
    private String productName;
    private String providerName;

    @Setter
    private int progressPercentage;
    private int completedDocsCount;
    private int totalDocsCount;
}