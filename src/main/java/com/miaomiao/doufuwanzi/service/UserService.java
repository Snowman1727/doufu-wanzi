package com.miaomiao.doufuwanzi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaomiao.doufuwanzi.domain.User;

/**
 * @author EDY
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-01-30 14:24:29
 */
public interface UserService extends IService<User> {
    User getUserByPhone(String phone);
}
