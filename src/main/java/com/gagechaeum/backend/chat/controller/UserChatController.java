package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.service.ChatService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/me/chatrooms")
@RequiredArgsConstructor
public class UserChatController {
	private final ChatService chatService;
	
	@GetMapping("")
	public CustomResponse<Object> getUserChatRooms(
		@RequestParam(value = "type", defaultValue = "all") String type,
		@AuthenticationPrincipal CustomUserDetails user
	) {
		Object response = chatService.getUserChatRooms(type, user.getUserId());
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}
