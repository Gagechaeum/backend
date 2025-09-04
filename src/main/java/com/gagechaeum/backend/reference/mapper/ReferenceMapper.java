package com.gagechaeum.backend.reference.mapper;

import com.gagechaeum.backend.reference.domain.Region;
import com.gagechaeum.backend.reference.dto.ReferenceTypeDto;
import com.gagechaeum.backend.reference.dto.RegionTypeDto;
import java.util.List;

public interface ReferenceMapper {
	List<ReferenceTypeDto> getDocumentTypes();

	List<ReferenceTypeDto> getIndustryTypes();

	List<Region> getRegionTypes();
}
