package com.miaomiao.doufuwanzi.business;

import com.miaomiao.doufuwanzi.pojo.dto.BaseDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserInfoDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserLoginDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
import com.miaomiao.doufuwanzi.pojo.vo.UserVo;

public interface UserManageService {

    UserVo register(UserRegisterDto dto);

    void login(UserLoginDto dto);

    void edit(UserInfoDto dto);

    void checkLoginStatus(BaseDto dto);
}
