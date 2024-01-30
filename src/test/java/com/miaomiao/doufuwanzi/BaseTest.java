package com.miaomiao.doufuwanzi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest(classes = DoufuWanziApplication.class)
@PropertySource("classpath:application.yml")
public class BaseTest {

    @Test
    public void test() {
        System.out.println("测试");
    }
}
