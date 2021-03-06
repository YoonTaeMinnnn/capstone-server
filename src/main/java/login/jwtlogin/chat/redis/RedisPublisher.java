package login.jwtlogin.chat.redis;

import login.jwtlogin.chat.chatDto.ChatSendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatSendDto chatSendDto) {
        redisTemplate.convertAndSend(topic.getTopic(), chatSendDto);
    }
}
