package com.gagechaeum.backend.chat.interceptor;

import com.gagechaeum.backend.security.util.JwtUtil;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtHandshakeInterceptor implements HandshakeInterceptor {
	private final JwtUtil jwtUtil;
	
	@Override
	public boolean beforeHandshake(
		ServerHttpRequest request,
		ServerHttpResponse response,
		WebSocketHandler wsHandler,
		Map<String, Object> attributes
	) {
		if (request instanceof ServletServerHttpRequest servletRequest) {
			HttpServletRequest httpServletRequest = servletRequest.getServletRequest();
			String token = httpServletRequest.getHeader("Authorization");
			
			if (token != null && token.startsWith("Bearer ")) {
				token = token.substring(7);
				
				if (jwtUtil.validateToken(token)) {
					Long userId = jwtUtil.getIdFromToken(token);
					attributes.put("userId", userId);
					return true;
				}
			}
		}
		return false;
	}
	@Override public void afterHandshake(
		ServerHttpRequest r,
		ServerHttpResponse s,
		WebSocketHandler h,
		Exception ex
	) {}
}
