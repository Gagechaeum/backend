package com.gagechaeum.backend.bookmark.mapper;

import com.gagechaeum.backend.bookmark.dto.BookmarkItemDto;
import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import java.util.List;
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
}
