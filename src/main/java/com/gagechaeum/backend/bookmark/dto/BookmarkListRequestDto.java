package com.gagechaeum.backend.bookmark.dto;

import lombok.Data;

@Data
public class BookmarkListRequestDto {
	private Integer page = 1;
	private Integer size = 10;
	private String type = "all";
	
	public Integer getOffset() {
		return (this.page - 1) * this.size;
	}
}
