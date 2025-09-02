package com.gagechaeum.backend.document.dto;

import java.util.Date;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDocumentUploadRequestDto {
    private MultipartFile file;     // 첨부파일
    private Long documentId;        // 서류 유형 ID
    private String documentName;    // 서류 이름
    private Date issuedAt;          // 발급일자
}
