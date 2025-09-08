package com.gagechaeum.backend.loan.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanListResponseDto {
	private List<LoanSummaryDto> loans;
}
