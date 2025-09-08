package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomSummaryDto;
import com.gagechaeum.backend.chat.mapper.ChatMapper;
import com.gagechaeum.backend.common.redis.RedisChatService;
import com.gagechaeum.backend.common.redis.RedisService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	private final ChatMapper chatMapper;
	private final RedisChatService redisChatService;
	
	public ChatRoomListResponseDto getChatRooms(String type) {
		List<ChatRoomSummaryDto> chatRooms = chatMapper.getChatRooms(type);
		
		chatRooms.forEach(room -> {
			room.setParticipantCount(
				redisChatService.getChatRoomParticipantCount(room.getRoomId())
			);
		});
		
		return new ChatRoomListResponseDto(chatRooms);
	}
	
	public UserChatRoomListResponseDto getUserChatRooms(String type, Long userId) {
		List<UserChatRoomSummaryDto> chatRooms = chatMapper.getUserChatRooms(type, userId);
		
		chatRooms.forEach(room -> {
			room.setParticipantCount(
				redisChatService.getChatRoomParticipantCount(room.getRoomId())
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
			redisChatService.getChatRoomParticipantCount(chatRoom.getRoomId())
		);
		return chatRoom;
	}
	
	public ChatRoomSummaryDto getLoanChatRoomDetails(Long loanId) {
		ChatRoomSummaryDto chatRoom = chatMapper.getChatRoomDetailsByLoanId(loanId);
		if (chatRoom == null) {
			throw new NoSuchElementException("채팅방이 존재하지 않습니다.");
		}
		chatRoom.setParticipantCount(
			redisChatService.getChatRoomParticipantCount(chatRoom.getRoomId())
		);
		return chatRoom;
	}
	
	public ChatRoomHistoryResponseDto getChatRoomHistory(
		ChatRoomHistoryRequestDto requestDto,
		Long roomId
	) {
		return new ChatRoomHistoryResponseDto(
			chatMapper.getChatRoomHistoryByRoomId(requestDto, roomId)
		);
	}
	
	@Transactional
	public void enterRoom(Long userId, Long roomId) {
		chatMapper.insertIfNotExists(userId, roomId);
		redisChatService.addChatRoomParticipant(userId, roomId);
	}
	
	@Transactional
	public void leaveRoom(Long roomId, Long userId) {
		chatMapper.deleteByRoomIdAndUserId(userId, roomId);
		redisChatService.removeChatRoomParticipant(userId, roomId);
	}
}
