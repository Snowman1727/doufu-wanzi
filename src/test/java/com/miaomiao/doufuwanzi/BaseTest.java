package com.miaomiao.doufuwanzi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest(classes = DoufuWanziApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("dev")
public class BaseTest {

    @Test
    public void test() {
        System.out.println("测试");
    }
}
