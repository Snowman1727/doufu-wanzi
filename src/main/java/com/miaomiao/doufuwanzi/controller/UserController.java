package com.miaomiao.doufuwanzi.controller;

import com.miaomiao.doufuwanzi.business.UserManageService;
import com.miaomiao.doufuwanzi.pojo.Result;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
import com.miaomiao.doufuwanzi.pojo.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserManageService userManageService;

    @PostMapping("/register")
    public Result<UserVo> register(@RequestBody UserRegisterDto dto) {
        log.info("register");
        return Result.success(userManageService.register(dto));
    }
}
