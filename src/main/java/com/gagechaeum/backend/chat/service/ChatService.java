package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;

public interface ChatService {
	ChatRoomListResponseDto getChatRooms(String type);
}
