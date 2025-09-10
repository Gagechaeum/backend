package com.gagechaeum.backend.chat.dto;

import java.util.List;
import lombok.Data;

@Data
public class SendMessageRequestDto {
	private String content;						// 메시지 내용
	private List<UploadedAttachmentDto> files;	// 첨부파일 목록
}
