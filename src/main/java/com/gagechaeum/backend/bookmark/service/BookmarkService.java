package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;

import java.util.List;

public interface BookmarkService {

    // 신청 현황 조회
    List<BookmarkResponseDTO> findBookmarksByUserId(Long userId);

    // 신청 상태 업데이트
    void updateBookmarkStatus(Long userId, String type, Long id, String status);
}
