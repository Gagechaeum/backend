package com.gagechaeum.backend.common.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisChatService {
	private final StringRedisTemplate redis;
	private final RedisMessageListenerContainer container;
	private final MessageListenerAdapter listenerAdapter;
	
	// ===== 채팅방 입/퇴장 (enter/leave) =====
	
	public void subscribeRoom(Long userId, Long roomId) {
		ChannelTopic topic = new ChannelTopic("chat:room:" + roomId);
		container.addMessageListener(listenerAdapter, topic);
		addChatRoomParticipant(userId, roomId);
	}
	
	public void unsubscribeRoom(Long userId, Long roomId) {
		ChannelTopic topic = new ChannelTopic("chat:room:" + roomId);
		container.removeMessageListener(listenerAdapter, topic);
		removeChatRoomParticipant(userId, roomId);
	}
	
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
