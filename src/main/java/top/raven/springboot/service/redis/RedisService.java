package top.raven.springboot.service.redis;

public interface RedisService {
    void setCache(String key, String token);
    boolean isCached(String token);
}
