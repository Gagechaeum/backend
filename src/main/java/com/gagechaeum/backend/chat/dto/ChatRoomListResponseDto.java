package com.gagechaeum.backend.chat.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatRoomListResponseDto {
	private List<ChatRoomSummaryDto> chatRooms;
}