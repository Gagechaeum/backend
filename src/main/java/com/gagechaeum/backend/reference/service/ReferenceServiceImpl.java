package com.gagechaeum.backend.reference.service;

import com.gagechaeum.backend.reference.domain.Region;
import com.gagechaeum.backend.reference.dto.ReferenceTypeListResponseDto;
import com.gagechaeum.backend.reference.dto.RegionTypeDto;
import com.gagechaeum.backend.reference.dto.RegionTypeListResponseDto;
import com.gagechaeum.backend.reference.mapper.ReferenceMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {
	private final ReferenceMapper referenceMapper;
	
	public ReferenceTypeListResponseDto getDocumentTypes() {
		return new ReferenceTypeListResponseDto(referenceMapper.getDocumentTypes());
	}
	
	public ReferenceTypeListResponseDto getIndustryTypes() {
		return new ReferenceTypeListResponseDto(referenceMapper.getIndustryTypes());
	}
	
	public RegionTypeListResponseDto getRegionTypes() {
		List<Region> allRegions = referenceMapper.getRegionTypes();
		
		Map<Long, RegionTypeDto> regionMap = new HashMap<>();
		List<RegionTypeDto> topLevelRegions = new ArrayList<>();
		
		for (Region region : allRegions)
			regionMap.put(region.getRegionId(), RegionTypeDto.fromVo(region));
		
		for (Region region : allRegions) {
			if (region.getSuperId() != null) {
				RegionTypeDto parent = regionMap.get(region.getSuperId());
				if (parent != null) {
					if (parent.getChildren() == null)
						parent.setChildren(new ArrayList<>());
					parent.getChildren().add(regionMap.get(region.getRegionId()));
				}
			}
			else
				topLevelRegions.add(regionMap.get(region.getRegionId()));
		}
		
		return new RegionTypeListResponseDto(topLevelRegions);
	}
}
