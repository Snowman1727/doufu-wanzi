package com.miaomiao.doufuwanzi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisService {

    private static final String ERROR_MSG = "Redis operation failed: ";

    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value, Long seconds) {
        stringRedisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public Boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public Boolean expire(String key, long seconds) {
        return handleRedisOperation((template) -> stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS));
    }

    public Boolean delete(String key) {
        return handleRedisOperation((template) -> stringRedisTemplate.delete(key));
    }

    private <T> T handleRedisOperation(RedisCallback<T> callback) {
        try {
            return callback.doInRedis(Objects.requireNonNull(stringRedisTemplate.getConnectionFactory()).getConnection());
        } catch (Exception e) {
            log.error(ERROR_MSG, e);
            return null;
        }
    }
}
