package com.gagechaeum.backend.bookmark.controller;

import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.dto.request.BookmarkStatusUpdateRequestDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkDocumentsResponseDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;
import com.gagechaeum.backend.bookmark.service.BookmarkService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/me")
@RequiredArgsConstructor
public class BookmarkController {
	private final BookmarkService bookmarkService;

	@GetMapping("/bookmarks")
	public CustomResponse<Object> getUserBookmarks(
			@ModelAttribute BookmarkListRequestDto requestDto,
			@AuthenticationPrincipal CustomUserDetails user
	) {
		Object response = bookmarkService.getUserBookmarks(requestDto, user.getUserId());
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}
    @GetMapping("/bookmarks/progress")
    public CustomResponse<List<BookmarkResponseDTO>> getBookmarks() {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        List<BookmarkResponseDTO> bookmarks = bookmarkService.findBookmarksByUserId(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, bookmarks);
    }

    @GetMapping("/bookmarks/documents")
    public CustomResponse<BookmarkDocumentsResponseDTO> getBookmarkDocuments() {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        BookmarkDocumentsResponseDTO response = bookmarkService.getBookmarkDocuments(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, response);
    }

    @PatchMapping("/policies/{id}/status")
    public CustomResponse<Void> updateUserPolicyStatus(
            @PathVariable Long id,
            @RequestBody BookmarkStatusUpdateRequestDTO request) {
        // TODO: 실제 사용자 ID 가져오기
        Long userId = 1L;
        bookmarkService.updateBookmarkStatus(userId, "policy", id, request.getStatus());
        return CustomResponse.success(ResponseCode.SUCCESS, null);
    }

    @PatchMapping("/loans/{id}/status")
    public CustomResponse<Void> updateUserLoanStatus(
            @PathVariable Long id,
            @RequestBody BookmarkStatusUpdateRequestDTO request) {
        // TODO: 실제 사용자 ID 가져오기
        Long userId = 1L;
        bookmarkService.updateBookmarkStatus(userId, "loan", id, request.getStatus());
        return CustomResponse.success(ResponseCode.SUCCESS, null);
    }
}
