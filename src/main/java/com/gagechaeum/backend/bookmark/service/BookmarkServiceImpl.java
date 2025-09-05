package com.gagechaeum.backend.bookmark.service;

import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;
import com.gagechaeum.backend.bookmark.mapper.BookmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkMapper bookmarkMapper;

    @Override
    public List<BookmarkResponseDTO> findBookmarksByUserId(Long userId) {

        List<BookmarkResponseDTO> bookmarks = bookmarkMapper.findBookmarksByUserId(userId);

        // 진행률(%) 계산
        for (BookmarkResponseDTO dto : bookmarks) {
            int progressPercentage;

            if (dto.getTotalDocsCount() > 0) {
                progressPercentage = (int) ((double) dto.getCompletedDocsCount() * 100 / dto.getTotalDocsCount());
            } else { // totalDocsCount가 0인 경우
                progressPercentage = 100;
            }
            dto.setProgressPercentage(progressPercentage);
        }

        return bookmarks;
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
