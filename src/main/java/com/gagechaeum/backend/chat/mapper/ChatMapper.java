package com.gagechaeum.backend.chat.mapper;

import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChatMapper {
	List<ChatRoomSummaryDto> getChatRooms(@Param("type") String type);
	
	ChatRoomSummaryDto getChatRoomDetailsByPolicyId(
		@Param("policyId") String policyId
	);
	
	ChatRoomSummaryDto getChatRoomDetailsByLoanId(
		@Param("loanId") Long loanId
	);
}
