package com.gagechaeum.backend.common.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisChatService {
	private final StringRedisTemplate redis;
	
	// ===== 채팅 참여자 수 관리 (Set operations) =====
	
	public void addChatRoomParticipant(Long userId, Long roomId) {
		String key = "chatroom:participants:" + roomId;
		redis.opsForSet().add(key, userId.toString());
	}
	
	public void removeChatRoomParticipant(Long userId, Long roomId) {
		String key = "chatroom:participants:" + roomId;
		redis.opsForSet().remove(key, userId.toString());
	}
	
	public Long getChatRoomParticipantCount(Long roomId) {
		String key = "chatroom:participants:" + roomId;
		Long count = redis.opsForSet().size(key);
		return (count != null) ? count : 0L;
	}
}
