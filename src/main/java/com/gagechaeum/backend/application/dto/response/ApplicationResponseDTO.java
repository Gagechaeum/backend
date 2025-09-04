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

    @Setter // 서비스 계층에서 계산 후 값을 세팅하기 위해 추가
    private int progressPercentage;

    private int completedDocsCount;
    private int totalDocsCount;
    private String actionButtonText;

    // MyBatis가 이 생성자를 사용해서 DB 조회 결과를 객체로 매핑합니다.
    public ApplicationResponseDTO(String applicationId, String processStage, String productType,
                                     String productName, String providerName,
                                     int completedDocsCount, int totalDocsCount, String actionButtonText) {
        this.applicationId = applicationId;
        this.processStage = processStage;
        this.productType = productType;
        this.productName = productName;
        this.providerName = providerName;
        this.completedDocsCount = completedDocsCount;
        this.totalDocsCount = totalDocsCount;
        this.actionButtonText = actionButtonText;
    }
}
