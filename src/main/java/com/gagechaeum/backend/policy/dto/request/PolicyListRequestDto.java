package com.gagechaeum.backend.policy.dto.request;

import lombok.Data;

@Data
public class PolicyListRequestDto {
	private Integer page = 1;
	private Integer size = 10;
	private Long industryId = null;
	
	public Integer getOffset() {
		return (this.page - 1) * this.size;
	}
}
