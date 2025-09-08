package com.gagechaeum.backend.chat.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ChatRoomHistoryRequestDto {
	private Integer page = 1;
	private Integer size = 50;
	private LocalDateTime since = null;
	
	public Integer getOffset() {
		return (this.page - 1) * this.size;
	}
}
