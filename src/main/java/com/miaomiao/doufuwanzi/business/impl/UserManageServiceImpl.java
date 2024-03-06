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
        if (userService.getUserByPhone(dto.getPhone()) != null) {
            throw new BusinessException(ErrorCode.USER_ALREADY_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.save(user);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfoService.save(userInfo);

        String token = UUIDUtils.generateUUID();
        redisManageService.cacheLoginStatus(token, dto.getPhone());

        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        vo.setToken(token);
        return vo;
    }

    @Override
    public void login(UserLoginDto dto) {
        log.info("登录");
    }

    @Override
    public UserVo query(String token) {
        log.info("查询用户信息");
        UserVo vo = new UserVo();
        String phone = redisManageService.getLoginStatus(token);
        if (phone == null) {
            throw new BusinessException(ErrorCode.USER_NOT_LOGIN);
        }
        User user = userService.getUserByPhone(phone);
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    @Override
    public void edit(String token, UserInfoDto dto) {
        log.info("编辑用户信息");
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(dto, userInfo);
        userInfo.setUpdateTime(new Date());
        String phone = redisManageService.getLoginStatus(token);
        Integer userId = userService.getUserByPhone(phone).getId();
        if (!userInfo.getUserId().equals(userId) || userInfo.getUserId() == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        userInfoService.updateByUserId(userInfo);
    }

    @Override
    public void checkLoginStatus(BaseDto dto) {
        log.info("检查登录状态");
    }
}
