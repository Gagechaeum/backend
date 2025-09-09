package com.gagechaeum.backend.chat.config;

import com.gagechaeum.backend.chat.interceptor.JwtChannelInterceptor;
import com.gagechaeum.backend.chat.interceptor.JwtHandshakeInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	private final JwtHandshakeInterceptor jwtHandshakeInterceptor;
	private final JwtChannelInterceptor jwtChannelInterceptor;
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws-stomp")
			.addInterceptors(jwtHandshakeInterceptor)
			.setAllowedOriginPatterns("*");
	}
	
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(jwtChannelInterceptor);
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 구독 prefix (서버 → 클라이언트)
		registry.enableSimpleBroker("/topic");
		// 발행 prefix (클라이언트 → 서버)
		registry.setApplicationDestinationPrefixes("/app");
	}
}
