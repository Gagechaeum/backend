package com.gagechaeum.backend.chat.listener;

import com.gagechaeum.backend.chat.service.ChatService;
import com.gagechaeum.backend.chat.util.ChatUtil;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import java.security.Principal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final ChatService chatService;

    @EventListener
    public void handleSessionConnected(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        if (sha.getUser() != null) {
            Long userId = ChatUtil.getUserIdFromPrincipal(sha.getUser());
            if (userId != null) {
                log.error("WS - 세션이 연결되었습니다. userId: " + userId);
            }
        }
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());

        Map<String, Object> sessionAttributes = sha.getSessionAttributes();
        if (sessionAttributes != null) {
            String roomId = (String) sessionAttributes.get("roomId");

            if (roomId != null && sha.getUser() != null) {
                Long userId = ChatUtil.getUserIdFromPrincipal(sha.getUser());
                if (userId != null) {
                    chatService.leavePage(userId, Long.valueOf(roomId));
                    log.error("WS - 세션이 종료되었습니다. userId: {}, roomId: {}", userId, roomId);
                }
            }
        }
    }
}
