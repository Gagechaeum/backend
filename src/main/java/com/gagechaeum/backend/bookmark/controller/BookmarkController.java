package com.gagechaeum.backend.bookmark.controller;

import com.gagechaeum.backend.bookmark.dto.request.BookmarkStatusUpdateRequestDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;
import com.gagechaeum.backend.bookmark.service.BookmarkService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/me")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/bookmarks")
    public CustomResponse<List<BookmarkResponseDTO>> getBookmarks() {
        // TODO: Get user ID from SecurityContext
        Long userId = 1L;
        List<BookmarkResponseDTO> bookmarks = bookmarkService.findBookmarksByUserId(userId);
        return CustomResponse.success(ResponseCode.SUCCESS, bookmarks);
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
