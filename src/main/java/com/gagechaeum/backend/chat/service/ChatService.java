package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;

public interface ChatService {
	ChatRoomListResponseDto getChatRooms(String type);
	
	ChatRoomSummaryDto getPolicyChatRoomDetails(String policyId);
	
	ChatRoomSummaryDto getLoanChatRoomDetails(Long loanId);
}
