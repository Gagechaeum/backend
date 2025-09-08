package com.gagechaeum.backend.chat.interceptor;

import com.gagechaeum.backend.security.util.JwtUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtChannelInterceptor implements ChannelInterceptor {
	private final JwtUtil jwtUtil;
	
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		
		if (StompCommand.CONNECT.equals(accessor.getCommand())) {
			String token = accessor.getFirstNativeHeader("Authorization");
			
			if (token != null && token.startsWith("Bearer ")) {
				token = token.substring(7);
				
				if (jwtUtil.validateToken(token)) {
					Long userId = jwtUtil.getIdFromToken(token);
					accessor.setUser(
						new UsernamePasswordAuthenticationToken(userId, null, List.of())
					);
				}
			}
		}
		return message;
	}
}
