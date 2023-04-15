package com.chen.annotation.controller;

import com.chen.annotation.config.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:TestController
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/15 17:26
 * @Version: v1.0
 */
@RestController
public class TestController {

    @Autowired
    MyConfiguration myConfiguration;

    @RequestMapping("/test")
    public String test(){
        return "haha";
    }
}
