package com.miaomiao.doufuwanzi;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.miaomiao.doufuwanzi.mapper")
public class DoufuWanziApplication {

    public static void main(String[] args) {
        log.info("DoufuWanziApplication启动");
        SpringApplication.run(DoufuWanziApplication.class, args);
    }

}
