package com.gagechaeum.backend.chat.dto;

import lombok.Data;

@Data
public class ChatRoomSummaryDto {
	private Long roomId;        // 채팅방 ID
	private String roomType;	// 채팅방 유형(업종, 지역, 대출, 정책)
	private String name;        // 채팅방 이름(업종명, 지역명, 대출상품명, 정책명)
}