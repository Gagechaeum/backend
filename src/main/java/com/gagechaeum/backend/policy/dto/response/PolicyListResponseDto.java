package com.gagechaeum.backend.policy.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PolicyListResponseDto {
	private List<PolicySummaryDto> policies;
}
