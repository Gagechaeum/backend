package com.gagechaeum.backend.bookmark.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BookmarkItemDto {
	private String policyId;
	private Long loanId;
	private String name;
	private LocalDate beginDate;
	private LocalDate endDate;
	private String applicationPeriod;
	private LocalDateTime createdAt;
}
