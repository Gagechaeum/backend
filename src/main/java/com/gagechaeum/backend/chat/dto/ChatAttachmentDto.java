package com.gagechaeum.backend.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatAttachmentDto {
	private String key;			// S3 Key
	private String extension;	// 확장자
	private String name;		// 원본 파일명
	private Long size;			// 파일 크기 (bytes)
}

