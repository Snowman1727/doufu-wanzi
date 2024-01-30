package com.miaomiao.doufuwanzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.miaomiao.doufuwanzi.mapper")
public class DoufuWanziApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoufuWanziApplication.class, args);
    }

}
