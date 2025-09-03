package com.gagechaeum.backend.reference.service;

import com.gagechaeum.backend.reference.dto.ReferenceTypeListResponseDto;
import com.gagechaeum.backend.reference.dto.RegionTypeListResponseDto;

public interface ReferenceService {
	ReferenceTypeListResponseDto getDocumentTypes();

	ReferenceTypeListResponseDto getIndustryTypes();

	RegionTypeListResponseDto getRegionTypes();
}
