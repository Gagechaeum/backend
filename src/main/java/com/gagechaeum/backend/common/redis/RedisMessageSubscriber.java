package com.gagechaeum.backend.common.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisMessageSubscriber {
	public void onMessage(String message) {
		// Redis 메시지가 수신되면 실행될 로직
		// 예: 웹소켓으로 클라이언트에게 메시지 전달
		System.out.println("Redis에서 수신된 메시지: " + message);
	}
}
