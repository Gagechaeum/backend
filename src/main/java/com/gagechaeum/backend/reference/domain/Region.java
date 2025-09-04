package com.gagechaeum.backend.reference.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Region {
	private Long regionId;		// 지역 ID
	private Long superId;		// 상위 지역 ID
	private Integer depth;		// 위계
	private String name;		// 지역명
	private String fullName;	// 전체 지역명
}
