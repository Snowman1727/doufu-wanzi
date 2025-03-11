package com.miaomiao.doufuwanzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomiao.doufuwanzi.domain.User;
import com.miaomiao.doufuwanzi.service.UserService;
import com.miaomiao.doufuwanzi.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author EDY
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-03-11 14:56:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




