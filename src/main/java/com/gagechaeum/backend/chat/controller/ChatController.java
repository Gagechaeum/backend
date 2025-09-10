package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.dto.ChatRoomHistoryRequestDto;
import com.gagechaeum.backend.chat.dto.UploadAttachmentRequestDto;
import com.gagechaeum.backend.chat.service.ChatService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/chatrooms")
@RequiredArgsConstructor
public class ChatController {
	private final ChatService chatService;
	
	@PostMapping(value = "/attachments", consumes = "multipart/form-data")
	public CustomResponse<Object> uploadAttachments(
		@ModelAttribute UploadAttachmentRequestDto requestDto,
		@AuthenticationPrincipal CustomUserDetails user
	) {
		Object response = chatService.uploadAttachments(requestDto, user.getUserId());
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("")
	public CustomResponse<Object> getChatRooms(
		@RequestParam(value = "type", defaultValue = "all") String type
	) {
		Object response = chatService.getChatRooms(type);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("/policies/{policy_id}")
	public CustomResponse<Object> getPolicyChatRoomDetails(
		@PathVariable("policy_id") String policyId
	) {
		Object response = chatService.getPolicyChatRoomDetails(policyId);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("/loans/{loan_id}")
	public CustomResponse<Object> getLoanChatRoomDetails(
		@PathVariable("loan_id") Long loanId
	) {
		Object response = chatService.getLoanChatRoomDetails(loanId);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
	
	@GetMapping("/{room_id}/history")
	public CustomResponse<Object> getChatRoomHistory(
		@ModelAttribute ChatRoomHistoryRequestDto requestDto,
		@PathVariable("room_id") Long roomId
	) {
		Object response = chatService.getChatRoomHistory(requestDto, roomId);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}
