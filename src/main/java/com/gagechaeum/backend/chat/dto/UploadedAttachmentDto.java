package com.gagechaeum.backend.chat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadedAttachmentDto {
	private String key;		// 파일 경로
	private String name;	// 원본 파일명
	private String type;	// 파일 타입
}
