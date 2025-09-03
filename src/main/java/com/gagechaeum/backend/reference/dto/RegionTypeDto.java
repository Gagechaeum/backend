package com.gagechaeum.backend.reference.dto;

import com.gagechaeum.backend.reference.domain.Region;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegionTypeDto {
	private Long regionId;
	private String name;
	private String fullName;
	private List<RegionTypeDto> children;
	
	public static RegionTypeDto fromVo(Region region) {
		return RegionTypeDto
			.builder()
			.regionId(region.getRegionId())
			.name(region.getName())
			.fullName(region.getFullName())
			.build();
	}
}
