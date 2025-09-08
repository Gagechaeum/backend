package com.gagechaeum.backend.chat.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import com.gagechaeum.backend.chat.service.ChatService;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
	private final ChatService chatService;
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		Long userId = (Long) event.getMessage().getHeaders().get("userId");
		Long roomId = (Long) event.getMessage().getHeaders().get("roomId");
		
		if (userId != null) {
			chatService.leavePage(userId, roomId);
			log.info("사용자 {}가 채팅방 {}에서 연결이 끊어졌습니다.", userId, roomId);
		}
	}
}