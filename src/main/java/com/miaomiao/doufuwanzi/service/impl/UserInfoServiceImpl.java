package com.miaomiao.doufuwanzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaomiao.doufuwanzi.domain.UserInfo;
import com.miaomiao.doufuwanzi.mapper.UserInfoMapper;
import com.miaomiao.doufuwanzi.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author EDY
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2024-03-06 14:46:57
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    @Override
    public void updateByUserId(UserInfo userInfo) {
        this.lambdaUpdate()
                .eq(UserInfo::getUserId, userInfo.getUserId())
                .set(UserInfo::getDescription, userInfo.getDescription())
                .set(UserInfo::getEmail, userInfo.getEmail())
                .set(UserInfo::getPhotoUrl, userInfo.getPhotoUrl())
                .set(UserInfo::getBirthday, userInfo.getBirthday())
                .set(UserInfo::getUpdateTime, userInfo.getUpdateTime())
                .update();
    }
}




