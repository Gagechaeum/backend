package com.gagechaeum.backend.bookmark.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookmarkStatusUpdateRequestDTO {
    private String status; // "요건확인", "제출 준비" 등 새로운 상태 값
}
