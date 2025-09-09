package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import java.security.Principal;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatStompController {
	private final SimpMessagingTemplate messagingTemplate;
	
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
