package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.service.ChatService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.document.dto.UserDocumentUploadRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/chatrooms")
@RequiredArgsConstructor
public class ChatController {
	private final ChatService chatService;
	
	@GetMapping("")
	public CustomResponse<Object> getChatRooms(
		@RequestParam(value = "type", defaultValue = "all") String type
	) {
		Object response = chatService.getChatRooms(type);
		return CustomResponse.success(ResponseCode.SUCCESS, response);
	}
}
