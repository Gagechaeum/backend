package com.gagechaeum.backend.bookmark.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookmarkListResponseDto {
    private List<BookmarkItemDto> bookmarks;
}
