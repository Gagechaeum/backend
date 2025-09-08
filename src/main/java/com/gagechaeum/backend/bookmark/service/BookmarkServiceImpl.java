package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.BookmarkItemDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListResponseDto;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkDocumentsResponseDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;
import com.gagechaeum.backend.bookmark.mapper.BookmarkMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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
        } else if ("loan".equals(requestDto.getType())) {
            return getUserLoanBookmarks(requestDto, userId);
        } else if ("all".equals(requestDto.getType())) {
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

    // ✅ 네 코드에서 추가된 기능들

    @Override
    public List<BookmarkResponseDTO> findBookmarksByUserId(Long userId) {
        List<BookmarkResponseDTO> bookmarks = bookmarkMapper.findBookmarksByUserId(userId);

        // 진행률(%) 계산
        for (BookmarkResponseDTO dto : bookmarks) {
            int progressPercentage;
            if (dto.getTotalDocsCount() > 0) {
                progressPercentage = (int) ((double) dto.getCompletedDocsCount() * 100 / dto.getTotalDocsCount());
            } else {
                progressPercentage = 100;
            }
            dto.setProgressPercentage(progressPercentage);
        }

        return bookmarks;
    }

    @Override
    @Transactional(readOnly = true)
    public BookmarkDocumentsResponseDTO getBookmarkDocuments(Long userId) {
        int totalBookmarkCount = bookmarkMapper.countTotalBookmarksByUserId(userId);
        List<BookmarkDocumentsResponseDTO.DocumentInfoDTO> documents = bookmarkMapper.findBookmarkDocumentsByUserId(userId);

        return new BookmarkDocumentsResponseDTO(totalBookmarkCount, documents);
    }

    @Override
    @Transactional
    public void updateBookmarkStatus(Long userId, String type, Long id, String status) {
        if ("policy".equalsIgnoreCase(type)) {
            bookmarkMapper.updateUserPolicyStatus(userId, id, status);
        } else if ("loan".equalsIgnoreCase(type)) {
            bookmarkMapper.updateUserLoanStatus(userId, id, status);
        } else {
            throw new IllegalArgumentException("Invalid bookmark type: " + type);
        }
    }
}