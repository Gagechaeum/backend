package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.ProductInfo;
import com.gagechaeum.backend.document.dto.response.DocumentChecklistResponseDto;
import com.gagechaeum.backend.document.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentChecklistServiceImpl implements DocumentChecklistService {

    private final DocumentMapper documentMapper;

    @Override
    public DocumentChecklistResponseDto getDocumentChecklist(String itemType, String itemId, Long userId) {
        ProductInfo productInfo;
        List<DocumentChecklistResponseDto.DocumentStatusDto> documents;

        if ("policy".equalsIgnoreCase(itemType)) {
            productInfo = documentMapper.findPolicyDetailsById(itemId);
            documents = documentMapper.findRequiredDocumentsWithStatusByPolicyId(itemId, userId);
        } else if ("loan".equalsIgnoreCase(itemType)) {
            productInfo = documentMapper.findLoanDetailsById(Long.parseLong(itemId));
            documents = documentMapper.findRequiredDocumentsWithStatusByLoanId(Long.parseLong(itemId), userId);
        } else {
            throw new IllegalArgumentException("Invalid item type: " + itemType);
        }

        if (productInfo == null) {
            // Or throw a specific not found exception
            return null;
        }

        return new DocumentChecklistResponseDto(productInfo.getName(), productInfo.getOrganization(), documents);
    }
}
