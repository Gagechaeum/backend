package com.gagechaeum.backend.chat.service;

import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomListResponseDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.SendMessageRequestDto;
import com.gagechaeum.backend.chat.dto.UploadAttachmentRequestDto;
import com.gagechaeum.backend.chat.dto.UploadAttachmentResponseDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomListResponseDto;

public interface ChatService {
	UploadAttachmentResponseDto uploadAttachments(
		UploadAttachmentRequestDto requestDto,
		Long userId
	);
	
	ChatRoomListResponseDto getChatRooms(String type);
	
	UserChatRoomListResponseDto getUserChatRooms(String type, Long userId);
	
	ChatRoomSummaryDto getPolicyChatRoomDetails(String policyId);
	
	ChatRoomSummaryDto getLoanChatRoomDetails(Long loanId);
	
	ChatRoomHistoryResponseDto getChatRoomHistory(
		ChatRoomHistoryRequestDto requestDto,
		Long roomId
	);
	
	void enterRoom(Long userId, Long roomId);
	
	void leaveRoom(Long userId, Long roomId);

	void leavePage(Long userId, Long roomId);
	
	void sendMessage(SendMessageRequestDto requestDto, Long userId, Long roomId);
}
