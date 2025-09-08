package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomSummaryDto;
import com.gagechaeum.backend.chat.mapper.ChatMapper;
import com.gagechaeum.backend.common.redis.RedisService;
import java.util.List;
import java.util.NoSuchElementException;
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
		
		return new ChatRoomListResponseDto(chatRooms);
	}
	
	public UserChatRoomListResponseDto getUserChatRooms(String type, Long userId) {
		List<UserChatRoomSummaryDto> chatRooms = chatMapper.getUserChatRooms(type, userId);
		
		chatRooms.forEach(room -> {
			room.setParticipantCount(
				redisService.getChatRoomParticipantCount(room.getRoomId())
			);
		});
		
		return new UserChatRoomListResponseDto(chatRooms);
	}
	
	public ChatRoomSummaryDto getPolicyChatRoomDetails(String policyId) {
		ChatRoomSummaryDto chatRoom = chatMapper.getChatRoomDetailsByPolicyId(policyId);
		if (chatRoom == null) {
			throw new NoSuchElementException("채팅방이 존재하지 않습니다.");
		}
		chatRoom.setParticipantCount(
			redisService.getChatRoomParticipantCount(chatRoom.getRoomId())
		);
		return chatRoom;
	}
	
	public ChatRoomSummaryDto getLoanChatRoomDetails(Long loanId) {
		ChatRoomSummaryDto chatRoom = chatMapper.getChatRoomDetailsByLoanId(loanId);
		if (chatRoom == null) {
			throw new NoSuchElementException("채팅방이 존재하지 않습니다.");
		}
		chatRoom.setParticipantCount(
			redisService.getChatRoomParticipantCount(chatRoom.getRoomId())
		);
		return chatRoom;
	}
}
