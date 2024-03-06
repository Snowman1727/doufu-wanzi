package com.miaomiao.doufuwanzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ServletComponentScan
@MapperScan("com.miaomiao.doufuwanzi.mapper")
public class DoufuWanziApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DoufuWanziApplication.class, args);
    }

    @Override //为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
