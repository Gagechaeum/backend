package com.gagechaeum.backend.document.dto;

import java.io.InputStream;
import lombok.Builder;

@Builder
public class UserDocumentDownloadResponseDto {
	private InputStream file; // 하나일 경우
	private byte[] zipFile;   // 여러 개일 경우
}