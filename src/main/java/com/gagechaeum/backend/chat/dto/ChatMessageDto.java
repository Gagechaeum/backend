package com.gagechaeum.backend.chat.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageDto {
	private Long messageId;
	private Long userId;						// 송신자 ID
	private Long roomId;
	private String content;						// 메시지 내용
	private LocalDateTime sentAt;				// 전송 시간
	private List<UploadedAttachmentDto> files;	// 첨부파일 목록
	
	public ChatMessageDto(SendMessageRequestDto requestDto, Long userId, Long roomId) {
		this.userId = userId;
		this.roomId = roomId;
		this.content = requestDto.getContent();
		this.sentAt = LocalDateTime.now();
		this.files = requestDto.getFiles();
	}
}
