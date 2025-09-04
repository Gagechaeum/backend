package com.gagechaeum.backend.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponseDTO {
    private String applicationId;
    private String processStage;
    private String productType;
    private String productName;
    private String providerName;

    @Setter
    private int progressPercentage;
    private int completedDocsCount;
    private int totalDocsCount;
}