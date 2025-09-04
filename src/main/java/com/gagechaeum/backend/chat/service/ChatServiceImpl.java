package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.mapper.ChatMapper;
import com.gagechaeum.backend.common.redis.RedisService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	private final ChatMapper chatMapper;
	private final RedisService redisService;
	
	public ChatRoomListResponseDto getChatRooms(String type) {
		List<ChatRoomSummaryDto> chatRooms = chatMapper.getChatRooms(type);
		
		chatRooms.forEach(room -> {
			room.setParticipantCount(
				redisService.getChatRoomParticipantCount(room.getRoomId())
			);
		});
		
		return ChatRoomListResponseDto
			.builder()
			.chatRooms(chatMapper.getChatRooms(type))
			.build();
	}
}
