package top.raven.springboot.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.raven.springboot.service.token.TokenService;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TokenService tokenService;
    @Override
    public void setCache(String key, String token) {
        redisTemplate.opsForValue()
                .set(key, token, tokenService.getExpiration(), TimeUnit.SECONDS);
    }

    @Override
    public boolean isCached(String token) {
        String username = tokenService.getUsername(token);
        String sourceToken = redisTemplate.opsForValue().get(username);
        return sourceToken != null && sourceToken.equals(token);
    }
}
