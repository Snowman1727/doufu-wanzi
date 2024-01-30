package com.miaomiao.doufuwanzi.business;

import com.miaomiao.doufuwanzi.pojo.dto.BaseDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserLoginDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;

public interface UserManageService {

    void register(UserRegisterDto dto);

    void login(UserLoginDto dto);

    void checkLoginStatus(BaseDto dto);
}
