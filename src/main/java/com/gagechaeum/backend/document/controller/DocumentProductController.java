package com.gagechaeum.backend.document.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.response.ItemsByDocumentResponseDto;
import com.gagechaeum.backend.document.service.DocumentProductService;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/documents/{documentId}/products")
@RequiredArgsConstructor
public class DocumentProductController {

    private final DocumentProductService documentProductService;

    @GetMapping
    public CustomResponse<List<ItemsByDocumentResponseDto>> getProductsByDocument(
            @PathVariable Long documentId,
            @AuthenticationPrincipal CustomUserDetails user) {
        List<ItemsByDocumentResponseDto> products = documentProductService.getProductsByDocument(documentId, user.getUserId());
        return CustomResponse.success(ResponseCode.SUCCESS, products);
    }
}
