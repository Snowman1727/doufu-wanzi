package com.miaomiao.doufuwanzi.service;

import com.miaomiao.doufuwanzi.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author EDY
* @description 针对表【user】的数据库操作Service
* @createDate 2024-03-06 12:44:10
*/
public interface UserService extends IService<User> {
    User getUserByPhone(String phone);
}
