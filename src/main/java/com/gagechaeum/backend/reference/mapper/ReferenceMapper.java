package com.gagechaeum.backend.reference.mapper;

import com.gagechaeum.backend.reference.dto.ReferenceTypeDto;
import java.util.List;

public interface ReferenceMapper {
	List<ReferenceTypeDto> getDocumentTypes();
}
