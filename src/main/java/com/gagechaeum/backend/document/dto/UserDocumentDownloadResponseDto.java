package com.gagechaeum.backend.document.dto;

import java.io.InputStream;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDocumentDownloadResponseDto {
	private String fileUrl;	// 하나일 경우, 5분간 다운로드 가능한 URL 반환
	private byte[] zipFile;	// 여러 개일 경우, zip파일 반환
}