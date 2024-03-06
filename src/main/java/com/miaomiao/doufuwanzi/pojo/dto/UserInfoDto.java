package com.miaomiao.doufuwanzi.pojo.dto;

import lombok.Data;

@Data
public class UserInfoDto {

    private Integer userId;

    private String description;

    private String email;

    private String photoUrl;

    private String birthday;
}
