package com.miaomiao.doufuwanzi.controller;

import com.miaomiao.doufuwanzi.business.UserManageService;
import com.miaomiao.doufuwanzi.pojo.Result;
import com.miaomiao.doufuwanzi.pojo.dto.UserInfoDto;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
import com.miaomiao.doufuwanzi.pojo.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserManageService userManageService;

    /**
     * 用户注册
     *
     * @param dto 用户注册信息
     * @return 注册结果，包含注册成功的用户信息
     */
    @PostMapping("/register")
    public Result<UserVo> register(@RequestBody UserRegisterDto dto) {
        return Result.success(userManageService.register(dto));
    }

    /**
     * 用户信息编辑
     *
     * @param request HttpServletRequest对象，用于获取请求头信息
     * @param dto     要编辑的用户信息
     * @return 编辑结果，成功返回空结果
     */
    @PostMapping("/edit")
    public Result<String> edit(HttpServletRequest request, @RequestBody UserInfoDto dto) {
        String token = request.getHeader("token"); // 从请求头中获取token
        userManageService.edit(token, dto); // 根据token和传入的用户信息编辑用户
        return Result.success();
    }
}
