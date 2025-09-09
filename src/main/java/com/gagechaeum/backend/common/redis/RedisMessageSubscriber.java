package com.gagechaeum.backend.common.redis;

import com.gagechaeum.backend.chat.dto.ChatMessageDto;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
	private final SimpMessagingTemplate messagingTemplate;
	private final ObjectMapper objectMapper;
	
	// 서버 -> 클라이언트(구독자)
	@Override
	public void onMessage(Message message, byte[] pattern) {
		try {
			String payload = new String(message.getBody(), StandardCharsets.UTF_8);
			ChatMessageDto chatMessage = objectMapper.readValue(payload, ChatMessageDto.class);
			
			// 구독한 경로
			String dest = "/topic/chatrooms/" + chatMessage.getRoomId();
			messagingTemplate.convertAndSend(dest, chatMessage);
		} catch (Exception e) {
			log.error("WS - topic 오류가 발생했습니다: " + e.getMessage());
		}
	}
}

