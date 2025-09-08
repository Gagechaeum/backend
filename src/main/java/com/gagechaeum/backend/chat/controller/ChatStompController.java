package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.service.ChatService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import java.security.Principal;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatStompController {
	private final ChatService chatService;
	private final SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/chatrooms/{room_id}/enter")
	public void enterRoom(
		@DestinationVariable("room_id") String roomId,
		Principal principal,
		SimpMessageHeaderAccessor headerAccessor
	) {
		Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
		if (sessionAttributes == null) {
			headerAccessor.setSessionAttributes(new HashMap<>());
		}
		headerAccessor.getSessionAttributes().put("roomId", roomId);
		
		chatService.enterRoom(
			Long.valueOf(principal.getName()),
			Long.valueOf(roomId)
		);
	}
	
	@MessageMapping("/chatrooms/{room_id}/leave")
	public void leaveRoom(
		@DestinationVariable("room_id") String roomId,
		Principal principal
	) {
		chatService.leaveRoom(
			Long.valueOf(principal.getName()),
			Long.valueOf(roomId)
		);
	}
	
	@MessageMapping("/chatrooms/{room_id}/send")
	public void sendMessage(
		@DestinationVariable("room_id") String roomId,
		ChatMessageDto messageDto,
		Principal principal
	) {
		messageDto.setUserId(Long.valueOf(principal.getName()));
		messageDto.setSentAt(LocalDateTime.now());
		messagingTemplate.convertAndSend("/topic/chatrooms/" + roomId, messageDto);
	}
}
