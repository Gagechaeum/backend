package com.gagechaeum.backend.bookmark.mapper;

import com.gagechaeum.backend.bookmark.dto.BookmarkItemDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import java.util.List;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkDocumentsResponseDTO;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkProductResponseDto;
import com.gagechaeum.backend.bookmark.dto.response.BookmarkResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookmarkMapper {
	List<BookmarkItemDto> getUserPolicyBookmarks(
		@Param("requestDto") BookmarkListRequestDto requestDto,
		@Param("userId") Long userId
	);

	List<BookmarkItemDto> getUserPolicyBookmarksWithPagination(
			@Param("requestDto") BookmarkListRequestDto requestDto,
			@Param("userId") Long userId
	);

	List<BookmarkItemDto> getUserLoanBookmarks(
		@Param("requestDto") BookmarkListRequestDto requestDto,
		@Param("userId") Long userId
	);

	List<BookmarkItemDto> getUserLoanBookmarksWithPagination(
			@Param("requestDto") BookmarkListRequestDto requestDto,
			@Param("userId") Long userId
	);

    // 신청 현황 조회
    List<BookmarkResponseDTO> findBookmarksByUserId(Long userId);

    int countTotalBookmarksByUserId(Long userId);

    List<BookmarkDocumentsResponseDTO.DocumentInfoDTO> findBookmarkDocumentsByUserId(Long userId);

    // 정책 신청 상태 업데이트
    int updateUserPolicyStatus(@Param("userId") Long userId, @Param("id") Long id, @Param("status") String status);

    // 대출 신청 상태 업데이트
    int updateUserLoanStatus(@Param("userId") Long userId, @Param("id") Long id, @Param("status") String status);

	List<BookmarkProductResponseDto> findBookmarkedProducts(@Param("userId") Long userId);

    void insertPolicyBookmark(@Param("userId") Long userId, @Param("policyId") String policyId);

    void insertLoanBookmark(@Param("userId") Long userId, @Param("loanId") Long loanId);

    void deletePolicyBookmark(@Param("userId") Long userId, @Param("policyId") String policyId);

    void deleteLoanBookmark(@Param("userId") Long userId, @Param("loanId") Long loanId);
}
