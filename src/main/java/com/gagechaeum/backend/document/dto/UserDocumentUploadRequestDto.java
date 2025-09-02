package com.gagechaeum.backend.document.dto;

import java.util.Date;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDocumentUploadRequestDto {
    private MultipartFile file;
    private Long documentId;
    private String documentName;
    private Date issuedAt;
}
