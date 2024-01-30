package com.miaomiao.doufuwanzi.controller;

import com.miaomiao.doufuwanzi.business.UserManageService;
import com.miaomiao.doufuwanzi.pojo.Result;
import com.miaomiao.doufuwanzi.pojo.dto.UserRegisterDto;
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
    public Result<String> register(@RequestBody UserRegisterDto dto) {
        log.info("register");
        userManageService.register(dto);
        return Result.success();
    }
}
