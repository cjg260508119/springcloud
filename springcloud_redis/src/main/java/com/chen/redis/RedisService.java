package com.chen.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author 26050
 * @Date 2023/5/31 23:01
 * @Version 1.0
 */
@Service
public class RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    public void test(){
        redisTemplate.opsForValue().set("test", "test");
    }
}
