package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListResponseDto;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkDocumentsResponseDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkProductResponseDto;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;

import java.util.List;

public interface BookmarkService {
	BookmarkListResponseDto getUserBookmarks(BookmarkListRequestDto requestDto, Long userId);

    // 신청 현황 조회
    List<BookmarkResponseDTO> findBookmarksByUserId(Long userId);

    BookmarkDocumentsResponseDTO getBookmarkDocuments(Long userId);

    // 신청 상태 업데이트
    void updateBookmarkStatus(Long userId, String type, Long id, String status);

    List<BookmarkProductResponseDto> getBookmarkedProducts(Long userId);

    void createPolicyBookmark(Long userId, String policyId);

    void createLoanBookmark(Long userId, Long loanId);
}
