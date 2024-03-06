package com.miaomiao.doufuwanzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomiao.doufuwanzi.domain.User;
import com.miaomiao.doufuwanzi.mapper.UserMapper;
import com.miaomiao.doufuwanzi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author EDY
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-03-06 12:44:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public User getUserByPhone(String phone) {
        return this.lambdaQuery().eq(User::getPhone, phone).one();
    }
}




