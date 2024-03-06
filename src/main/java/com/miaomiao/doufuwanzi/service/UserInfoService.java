package com.miaomiao.doufuwanzi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miaomiao.doufuwanzi.domain.UserInfo;

/**
 * @author EDY
 * @description 针对表【user_info】的数据库操作Service
 * @createDate 2024-03-06 14:46:57
 */
public interface UserInfoService extends IService<UserInfo> {

    void updateByUserId(UserInfo userInfo);
}
