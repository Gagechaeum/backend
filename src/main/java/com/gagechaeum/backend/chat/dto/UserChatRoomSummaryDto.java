package com.gagechaeum.backend.chat.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserChatRoomSummaryDto {
	private Long roomId;					// 채팅방 ID
	private String roomType;				// 채팅방 유형(업종, 지역, 대출, 정책)
	private String name;					// 채팅방 이름(업종명, 지역명, 대출상품명, 정책명)
	private String lastMessage;				// 마지막 메시지
	private LocalDateTime lastMessageDate;	// 마지막 메시지 수신 시간
	private LocalDateTime lastLeftAt;		// 채팅방 퇴장 시간
	private Integer unreadCount;			// 읽지 않은 메시지 개수(마지막으로 읽은 시간 이후의 메시지 개수)
	private Long participantCount;			// 참여자수
}