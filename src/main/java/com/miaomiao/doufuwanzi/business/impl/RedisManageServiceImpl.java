package com.miaomiao.doufuwanzi.business.impl;

import com.miaomiao.doufuwanzi.business.RedisManageService;
import com.miaomiao.doufuwanzi.enums.RedisExpire;
import com.miaomiao.doufuwanzi.enums.RedisPrefix;
import com.miaomiao.doufuwanzi.exception.BusinessException;
import com.miaomiao.doufuwanzi.utils.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class RedisManageServiceImpl implements RedisManageService {

    @Resource
    private RedisService redisService;

    @Override
    public void cacheLoginStatus(String key, String value) {
        redisService.set(RedisPrefix.LOGIN_TOKEN + key, value, RedisExpire.LOGIN_TOKEN);
    }


    @Override
    public String getLoginStatus(String key) {
        return redisService.get(RedisPrefix.LOGIN_TOKEN + key);
    }

    @Override
    public void verifyLoginStatus(String key, String value) {
        String phone = redisService.get(RedisPrefix.LOGIN_TOKEN + key);
        if (phone == null||!phone.equals(value)) {
            throw new BusinessException("token失效,token=" + RedisPrefix.LOGIN_TOKEN + key);
        }
    }

    @Override
    public void expireLoginStatus(String key, Long second) {
        redisService.expire(RedisPrefix.LOGIN_TOKEN + key, second);
    }
}
