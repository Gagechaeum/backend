package com.gagechaeum.backend.chat.dto;

import lombok.Data;

@Data
public class UploadedAttachmentDto {
	private String key;		// 파일 경로
	private String name;	// 원본 파일명
}
