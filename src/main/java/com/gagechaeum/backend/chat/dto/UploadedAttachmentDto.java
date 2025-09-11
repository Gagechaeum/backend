package com.gagechaeum.backend.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadedAttachmentDto {
	private Long attachmentId;	// 첨부파일 ID
	private String key;			// 파일 경로
	private String name;		// 원본 파일명
	private String type;		// 파일 타입
}
