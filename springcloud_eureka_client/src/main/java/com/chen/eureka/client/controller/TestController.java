package com.chen.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/23 21:28
 * @Version: v1.0
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
