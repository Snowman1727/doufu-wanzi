package com.miaomiao.doufuwanzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomiao.doufuwanzi.domain.UserInfo;
import com.miaomiao.doufuwanzi.service.UserInfoService;
import com.miaomiao.doufuwanzi.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author EDY
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2025-03-11 15:00:36
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




