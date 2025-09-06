package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListResponseDto;

public interface BookmarkService {
	BookmarkListResponseDto getUserBookmarks(BookmarkListRequestDto requestDto, Long userId);
}
