package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomListResponseDto;

public interface ChatService {
	ChatRoomListResponseDto getChatRooms(String type);
	
	UserChatRoomListResponseDto getUserChatRooms(String type, Long userId);
	
	ChatRoomSummaryDto getPolicyChatRoomDetails(String policyId);
	
	ChatRoomSummaryDto getLoanChatRoomDetails(Long loanId);
	
	ChatRoomHistoryResponseDto getChatRoomHistory(
		ChatRoomHistoryRequestDto requestDto,
		Long roomId
	);
}
