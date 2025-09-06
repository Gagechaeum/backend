package com.gagechaeum.backend.bookmark.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class BookmarkListResponseDto {
    private List<BookmarkItemDto> bookmarks;
}
