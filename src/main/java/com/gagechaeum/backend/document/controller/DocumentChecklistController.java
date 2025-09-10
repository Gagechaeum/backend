package com.gagechaeum.backend.document.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.response.DocumentChecklistResponseDto;
import com.gagechaeum.backend.document.service.DocumentChecklistService;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/{productId}/documents")
@RequiredArgsConstructor
public class DocumentChecklistController {

    private final DocumentChecklistService documentChecklistService;

    @GetMapping
    public CustomResponse<DocumentChecklistResponseDto> getDocumentChecklist(
            @PathVariable("productId") String productId,
            @RequestParam("type") String itemType,
            @AuthenticationPrincipal CustomUserDetails user) {

        DocumentChecklistResponseDto checklist = documentChecklistService.getDocumentChecklist(
                itemType,
                productId,
                user.getUserId()
        );
        return CustomResponse.success(ResponseCode.SUCCESS, checklist);
    }
}
