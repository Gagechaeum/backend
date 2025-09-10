package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.response.DocumentChecklistResponseDto;

public interface DocumentChecklistService {
    DocumentChecklistResponseDto getDocumentChecklist(String itemType, String itemId, Long userId);
}
