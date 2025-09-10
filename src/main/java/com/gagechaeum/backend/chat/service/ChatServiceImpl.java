package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.SendMessageRequestDto;
import com.gagechaeum.backend.chat.dto.UploadAttachmentRequestDto;
import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UploadAttachmentResponseDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomSummaryDto;
import com.gagechaeum.backend.chat.mapper.ChatMapper;
import com.gagechaeum.backend.common.redis.RedisChatService;
import com.gagechaeum.backend.common.util.S3ClientUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	private final ChatMapper chatMapper;
	private final RedisChatService redisChatService;
	private final RedisTemplate<String, Object> redisTemplate;
	private final S3ClientUtil s3ClientUtil;
	
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
		if (!chatMapper.existByUserIdAndRoomId(userId, roomId)) {
			chatMapper.insert(userId, roomId);
		}
		redisChatService.subscribeRoom(userId, roomId);
	}
	
	@Transactional
	public void leaveRoom(Long userId, Long roomId) {
		chatMapper.deleteByRoomIdAndUserId(userId, roomId);
		redisChatService.unsubscribeRoom(userId, roomId);
	}
	
	public void leavePage(Long userId, Long roomId) {
		chatMapper.updateLastLeftAt(userId, roomId);
	}
	
	@Transactional
	public void sendMessage(SendMessageRequestDto requestDto, Long userId, Long roomId) {
		ChatMessageDto chatMessageDto = new ChatMessageDto(requestDto, userId, roomId);
		
		// redis 채널 경로
		redisTemplate.convertAndSend("chat:room:" + roomId, chatMessageDto);
		chatMapper.insertMessage(chatMessageDto);
		chatMapper.insertAttachments(chatMessageDto.getMessageId(), chatMessageDto.getFiles());
	}
	
	@Transactional
	public UploadAttachmentResponseDto uploadAttachments(UploadAttachmentRequestDto requestDto, Long userId) {
		List<String> uploadedKeys = new ArrayList<>();
		
		for (MultipartFile attachment : requestDto.getFiles()) {
			String key = "chatAttachments/" +
				userId + "_" + requestDto.getRoomId() +
				"_" + UUID.randomUUID();
			
			try {
				s3ClientUtil.uploadFile(attachment, key);
				uploadedKeys.add(key);
			} catch (IOException e) {
				throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.");
			}
		}
		return new UploadAttachmentResponseDto(uploadedKeys);
	}
}
