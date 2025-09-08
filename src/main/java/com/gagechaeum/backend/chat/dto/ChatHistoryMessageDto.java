package com.gagechaeum.backend.chat.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatHistoryMessageDto {
	private Long messageId;					// 메시지 ID
	private String profileImageKey;			// 프로필 사진 key
	private String nickname;				// 닉네임
	private String message;					// 메시지 내용
	private LocalDateTime sentAt;			// 메시지 보낸 시간
	private List<ChatAttachmentDto> files;	// 첨부 파일 리스트
}
