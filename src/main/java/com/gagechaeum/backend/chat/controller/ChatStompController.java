package com.gagechaeum.backend.chat.controller;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import com.gagechaeum.backend.chat.dto.SendMessageRequestDto;
import com.gagechaeum.backend.chat.service.ChatService;
import com.gagechaeum.backend.chat.util.ChatUtil;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatStompController {
	private final ChatService chatService;

	// prefix "/app"은 WebSocketConfig에서 설정했기 때문에 자동으로 붙음
	@MessageMapping("/chatrooms/{room_id}/enter")
	public void enterRoom(
		@DestinationVariable("room_id") String roomId,
		Principal principal,
		SimpMessageHeaderAccessor headerAccessor
	) {
		Long userId = ChatUtil.getUserIdFromPrincipal(principal);
		if (userId == null) {
			log.error("WS - enterRoom: 사용자 ID를 찾을 수 없습니다.");
			return;
		}
		
		Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
		if (sessionAttributes == null) {
			headerAccessor.setSessionAttributes(new HashMap<>());
		}
		headerAccessor.getSessionAttributes().put("roomId", roomId);

		chatService.enterRoom(
			userId,
			Long.valueOf(roomId)
		);

		log.error("WS - 채팅방에 입장했습니다. userId: {}", userId);
	}

	@MessageMapping("/chatrooms/{room_id}/leave")
	public void leaveRoom(
		@DestinationVariable("room_id") String roomId,
		Principal principal
	) {
		Long userId = ChatUtil.getUserIdFromPrincipal(principal);
		if (userId == null) {
			log.error("WS - leaveRoom: 사용자 ID를 찾을 수 없습니다.");
			return;
		}
		chatService.leaveRoom(
			userId,
			Long.valueOf(roomId)
		);
		
		log.error("WS - 채팅방에서 퇴장했습니다. userId: {}", userId);
	}

	// 클라이언트(메시지 송신자) -> 서버
	@MessageMapping("/chatrooms/{room_id}/send")
	public void sendMessage(
		@DestinationVariable("room_id") String roomId,
		SendMessageRequestDto requestDto,
		Principal principal
	) {
		Long userId = ChatUtil.getUserIdFromPrincipal(principal);
		if (userId == null) {
			log.error("WS - sendMessage: 사용자 ID를 찾을 수 없습니다.");
			return;
		}
		
		chatService.sendMessage(requestDto, userId, Long.valueOf(roomId));
		
		log.error(
			"WS - 메시지가 전송되었습니다. userId: {}, message: {}", userId,
			requestDto.getContent()
		);
	}
}
