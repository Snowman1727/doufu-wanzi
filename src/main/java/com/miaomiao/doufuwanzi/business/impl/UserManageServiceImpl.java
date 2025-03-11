package com.miaomiao.doufuwanzi.business.impl;

import com.miaomiao.doufuwanzi.business.RedisManageService;
import com.miaomiao.doufuwanzi.business.UserManageService;
import com.miaomiao.doufuwanzi.domain.User;
import com.miaomiao.doufuwanzi.domain.UserInfo;
import com.miaomiao.doufuwanzi.enums.ErrorCode;
import com.miaomiao.doufuwanzi.exception.BusinessException;
import com.miaomiao.doufuwanzi.pojo.dto.BaseDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserInfoDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserLoginDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
import com.miaomiao.doufuwanzi.pojo.vo.UserVo;
import com.miaomiao.doufuwanzi.service.UserInfoService;
import com.miaomiao.doufuwanzi.service.UserService;
import com.miaomiao.doufuwanzi.utils.BeanUtils;
import com.miaomiao.doufuwanzi.utils.UUIDUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManageServiceImpl implements UserManageService {

    private final RedisManageService redisManageService;
    private final UserService userService;
    private final UserInfoService userInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVo register(UserRegisterDto dto) {
        log.info("注册用户");
        return null;
    }

    @Override
    public void login(UserLoginDto dto) {
        log.info("登录");
    }

    @Override
    public UserVo query(String token) {
        log.info("查询用户信息");
       return null;
    }

    @Override
    public void edit(String token, UserInfoDto dto) {
        log.info("编辑用户信息");
    }

    @Override
    public void checkLoginStatus(BaseDto dto) {
        log.info("检查登录状态");
    }
}
