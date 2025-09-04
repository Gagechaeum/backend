package com.gagechaeum.backend.chat.mapper;

import com.gagechaeum.backend.chat.dto.ChatRoomSummaryDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMapper {
	List<ChatRoomSummaryDto> getChatRooms(@Param("type") String type);
}
