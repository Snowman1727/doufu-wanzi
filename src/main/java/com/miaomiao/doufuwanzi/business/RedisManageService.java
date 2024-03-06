package com.miaomiao.doufuwanzi.business;

public interface RedisManageService {

    /**
     * 缓存登录状态
     *
     * @param key   键名
     * @param value 键值
     */
    void cacheLoginStatus(String key, String value);

    /**
     * 获取登录状态
     *
     * @param key 键名
     * @return 键值
     */
    String getLoginStatus(String key);

    /**
     * 验证登录状态
     *
     * @param key   键名
     * @param value 键值
     */
    void verifyLoginStatus(String key, String value);

    /**
     * 过期登录状态
     *
     * @param key    键名
     * @param second 过期时间（秒）
     */
    void expireLoginStatus(String key, Long second);
}
