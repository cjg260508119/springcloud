package com.chen.redis.test;

import java.time.Duration;

/**
 * @ClassName:DurationTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/3 11:12
 * @Version: v1.0
 */
public class DurationTest {

    public static void main(String[] args) {
        Duration duration = Duration.ofDays(1);
        System.out.println(duration.getSeconds());
    }
}
