package com.gagechaeum.backend.chat.mapper;

import com.gagechaeum.backend.chat.dto.ChatHistoryMessageDto;
import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UploadedAttachmentDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomSummaryDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChatMapper {
	int insert(
		@Param("userId") Long userId,
		@Param("roomId") Long roomId
	);
	
	int insertMessage(
		@Param("messageDto") ChatMessageDto messageDto
	);
	
	int insertAttachments(
		@Param("messageId") Long messageId,
		@Param("attachments") List<UploadedAttachmentDto> attachments
	);

	boolean existByUserIdAndRoomId(
		@Param("userId") Long userId,
		@Param("roomId") Long roomId
	);
	
	List<ChatRoomSummaryDto> getChatRooms(
		@Param("type") String type
	);
	
	List<UserChatRoomSummaryDto> getUserChatRooms(
		@Param("type") String type,
		@Param("userId") Long userId
	);
	
	ChatRoomSummaryDto getChatRoomDetailsByPolicyId(
		@Param("policyId") String policyId
	);
	
	ChatRoomSummaryDto getChatRoomDetailsByLoanId(
		@Param("loanId") Long loanId
	);
	
	List<ChatHistoryMessageDto> getChatRoomHistoryByRoomId(
		@Param("requestDto") ChatRoomHistoryRequestDto requestDto,
		@Param("roomId") Long roomId
	);
	
	int updateLastLeftAt(
		@Param("userId") Long userId,
		@Param("roomId") Long roomId
	);
	
	int deleteByRoomIdAndUserId(
		@Param("userId") Long userId,
		@Param("roomId") Long roomId
	);
}
