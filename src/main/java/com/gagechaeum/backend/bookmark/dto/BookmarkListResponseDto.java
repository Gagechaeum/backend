package com.gagechaeum.backend.bookmark.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookmarkListResponseDto {
    private List<BookmarkItemDto> bookmarks;
}
