package com.gagechaeum.backend.document.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Data
public class UserDocumentUploadRequestDto {
    private MultipartFile file;     // 첨부파일
    private Long documentId;        // 서류 유형 ID
    private String documentName;    // 서류 이름
    private LocalDate issuedAt;     // 발급일자
    
    public void validate() {
        if (this.getFile() == null ||
            this.getFile().isEmpty() ||
            this.getDocumentId() == null ||
            this.getDocumentName() == null ||
            this.getIssuedAt() == null
        ) {
            throw new IllegalArgumentException("파일과 메타데이터는 필수값이며, 빈 파일은 허용되지 않습니다.");
        }
    }
}
