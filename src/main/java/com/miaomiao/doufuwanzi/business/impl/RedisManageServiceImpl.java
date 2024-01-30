package com.miaomiao.doufuwanzi.business.impl;

import com.miaomiao.doufuwanzi.business.RedisManageService;
import com.miaomiao.doufuwanzi.enums.RedisExpire;
import com.miaomiao.doufuwanzi.enums.RedisPrefix;
import com.miaomiao.doufuwanzi.utils.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisManageServiceImpl implements RedisManageService {

    private final RedisService redisService;

    @Override
    public void cacheLoginStatus(String key, String value) {
        redisService.set(RedisPrefix.LOGIN_TOKEN + key, value, RedisExpire.LOGIN_TOKEN);
    }

    @Override
    public void verifyLoginStatus(String key, String value) {
        redisService.get(RedisPrefix.LOGIN_TOKEN + key);
    }

    @Override
    public void expireLoginStatus(String key, Long second) {
        redisService.expire(RedisPrefix.LOGIN_TOKEN + key, second);
    }
}
