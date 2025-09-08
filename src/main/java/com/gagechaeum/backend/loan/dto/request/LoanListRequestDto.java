package com.gagechaeum.backend.loan.dto.request;

import lombok.Data;

@Data
public class LoanListRequestDto {
	private Integer page = 1;
	private Integer size = 10;
	private Long industryId = null;
	private Integer offset;
	
	public Integer getOffset() {
		return (this.page - 1) * this.size;
	}
}
