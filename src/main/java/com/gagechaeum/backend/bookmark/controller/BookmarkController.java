package com.gagechaeum.backend.bookmark.controller;

import com.gagechaeum.backend.bookmark.dto.BookmarkListRequestDto;
import com.gagechaeum.backend.bookmark.service.BookmarkService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/me/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
	private final BookmarkService bookmarkService;

	@GetMapping("")
	public CustomResponse<Object> getUserBookmarks(
			@ModelAttribute BookmarkListRequestDto requestDto,
			@AuthenticationPrincipal CustomUserDetails user
	) {
		Object response = bookmarkService.getUserBookmarks(requestDto, user.getUserId());
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}