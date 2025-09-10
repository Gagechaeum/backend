package com.gagechaeum.backend.document.service;

import com.gagechaeum.backend.document.dto.response.ItemsByDocumentResponseDto;
import com.gagechaeum.backend.document.mapper.DocumentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DocumentProductServiceImpl implements DocumentProductService {

    private final DocumentMapper documentMapper;

    @Override
    public List<ItemsByDocumentResponseDto> getProductsByDocument(Long documentId, Long userId) {
        List<ItemsByDocumentResponseDto> policies = documentMapper.findPoliciesByDocumentId(documentId, userId);
        List<ItemsByDocumentResponseDto> loans = documentMapper.findLoansByDocumentId(documentId, userId);
        return Stream.concat(policies.stream(), loans.stream()).toList();
    }
}
