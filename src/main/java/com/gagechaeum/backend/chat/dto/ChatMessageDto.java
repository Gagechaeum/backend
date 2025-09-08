package com.gagechaeum.backend.chat.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ChatMessageDto {
	private String type;				// 메시지 유형(ENTER, MESSAGE, LEAVE)
	private Long roomId;				// 채팅방 ID
	private Long userId;				// 송신자 ID
	private String content;				// 메시지 내용
	private LocalDateTime sentAt;		// 전송 시간
	private List<MultipartFile> files;	// 첨부파일 목록
}
