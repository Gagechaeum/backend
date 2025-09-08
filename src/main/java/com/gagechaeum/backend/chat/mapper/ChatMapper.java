package com.gagechaeum.backend.chat.mapper;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import com.gagechaeum.backend.chat.dto.UserChatRoomSummaryDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChatMapper {
	List<ChatRoomSummaryDto> getChatRooms(@Param("type") String type);
	
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
	
	List<ChatMessageDto> getChatRoomHistoryByRoomId(
		@Param("requestDto") ChatRoomHistoryRequestDto requestDto,
		@Param("roomId") Long roomId
	);
}
