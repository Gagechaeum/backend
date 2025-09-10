package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.response.ItemsByDocumentResponseDto;
import java.util.List;

public interface DocumentProductService {
    List<ItemsByDocumentResponseDto> getProductsByDocument(Long documentId, Long userId);
}
