package com.miaomiao.doufuwanzi.business;

import com.miaomiao.doufuwanzi.pojo.dto.BaseDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserInfoDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserLoginDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
import com.miaomiao.doufuwanzi.pojo.vo.UserVo;

public interface UserManageService {

    /**
     * 用户注册接口。
     *
     * @param dto 用户注册信息对象，包含必要的注册数据。
     * @return 返回注册成功的用户信息Vo对象。
     */
    UserVo register(UserRegisterDto dto);

    /**
     * 用户登录接口。
     *
     * @param dto 用户登录信息对象，包含登录所需的用户名和密码等。
     */
    void login(UserLoginDto dto);

    /**
     * 用户信息编辑接口。
     *
     * @param token 用户登录状态标识，用于验证用户身份。
     * @param dto   要编辑的用户信息对象，包含需要更新的用户信息。
     */
    void edit(String token, UserInfoDto dto);

    /**
     * 检查用户登录状态接口。
     *
     * @param dto 可包含任意与用户登录状态相关的数据对象，用于验证或查询。
     */
    void checkLoginStatus(BaseDto dto);
}
