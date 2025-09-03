package com.gagechaeum.backend.reference.service;

import com.gagechaeum.backend.reference.dto.ReferenceTypeListResponseDto;
import com.gagechaeum.backend.reference.mapper.ReferenceMapper;
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
}
