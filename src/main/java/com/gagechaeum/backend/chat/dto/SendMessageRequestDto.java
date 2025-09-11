package com.gagechaeum.backend.chat.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageRequestDto {
	private String content;						// 메시지 내용
	private List<UploadedAttachmentDto> files;	// 첨부파일 목록
}
