package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	private final ChatMapper chatMapper;
	
	public ChatRoomListResponseDto getChatRooms(String type) {
		return ChatRoomListResponseDto
			.builder()
			.chatRooms(chatMapper.getChatRooms(type))
			.build();
	}
}
