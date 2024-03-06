package com.miaomiao.doufuwanzi.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDto {

    private Integer userId;

    private String description;

    private String email;

    private String photoUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
