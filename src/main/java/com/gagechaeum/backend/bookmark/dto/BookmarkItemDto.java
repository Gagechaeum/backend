package com.gagechaeum.backend.bookmark.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BookmarkItemDto {
	private String policy_id;
	private Long loan_id;
	private String name;
	private LocalDate beginDate;
	private LocalDate endDate;
	private String applicationPeriod;
	private LocalDateTime createdAt;
}
