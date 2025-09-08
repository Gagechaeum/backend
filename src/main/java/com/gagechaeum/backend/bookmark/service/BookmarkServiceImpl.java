package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.BookmarkItemDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListResponseDto;
import com.gagechaeum.backend.bookmark.mapper.BookmarkMapper;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {
    private final BookmarkMapper bookmarkMapper;
    
    @Override
    public BookmarkListResponseDto getUserBookmarks(
            BookmarkListRequestDto requestDto,
            Long userId
    ) {
        if ("policy".equals(requestDto.getType())) {
            return getUserPolicyBookmarks(requestDto, userId);
        }
        else if ("loan".equals(requestDto.getType())) {
            return getUserLoanBookmarks(requestDto, userId);
        }
        else if ("all".equals(requestDto.getType())) {
            return getUserAllBookmarks(requestDto, userId);
        }
        throw new IllegalArgumentException("type 쿼리 파라미터가 유효하지 않습니다.");
    }
    
    public BookmarkListResponseDto getUserPolicyBookmarks(
            BookmarkListRequestDto requestDto,
            Long userId
    ) {
        return new BookmarkListResponseDto(
            bookmarkMapper.getUserPolicyBookmarksWithPagination(requestDto, userId)
        );
    }
    
    public BookmarkListResponseDto getUserLoanBookmarks(
            BookmarkListRequestDto requestDto,
            Long userId
    ) {
        return new BookmarkListResponseDto(
            bookmarkMapper.getUserLoanBookmarksWithPagination(requestDto, userId)
        );
    }
    
    public BookmarkListResponseDto getUserAllBookmarks(
            BookmarkListRequestDto requestDto,
            Long userId
    ) {
        List<BookmarkItemDto> policies = bookmarkMapper.getUserPolicyBookmarks(requestDto, userId);
        List<BookmarkItemDto> loans = bookmarkMapper.getUserLoanBookmarks(requestDto, userId);
        
        List<BookmarkItemDto> allBookmarks = Stream.concat(policies.stream(), loans.stream())
            .sorted(Comparator.comparing(BookmarkItemDto::getCreatedAt).reversed())
            .toList();
        
        return new BookmarkListResponseDto(
            paginationAllBookmarks(requestDto, allBookmarks)
        );
    }
    
    public List<BookmarkItemDto> paginationAllBookmarks(
            BookmarkListRequestDto requestDto,
            List<BookmarkItemDto> allBookmarks
    ) {
        int offset = requestDto.getOffset();
        int limit = requestDto.getSize();
        int totalSize = allBookmarks.size();
        
        if (offset >= totalSize) {
            return Collections.emptyList();
        }
        return allBookmarks.subList(offset, Math.min(offset + limit, totalSize));
    }
}
