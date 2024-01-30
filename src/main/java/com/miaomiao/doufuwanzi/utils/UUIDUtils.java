package com.miaomiao.doufuwanzi.utils;

import lombok.Data;

import java.util.Random;
import java.util.UUID;

@Data
public class UUIDUtils {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取定长的随机数，包含大小写、数字
     *
     * @param length 随机数长度
     * @return
     */
    public static String getRandom(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(62);
            if (rand < 10) {
                val.append(rand);
            } else if (rand < 36) {
                val.append((char) (rand + 55));
            } else {
                val.append((char) (rand + 61));
            }
        }
        return val.toString();
    }
}
