package com.gagechaeum.backend.document.domain;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDocument {
	private Long userDocumentId;	// 업로드된 서류 ID
	private Long userId;			// 사용자 ID
	private Long documentId;		// 업로드할 서류 종류 ID
	private String documentName;	// 서류 이름
	private Date issuedAt;			// 서류 발급일
	private String fileKey;			// S3 Key
}
