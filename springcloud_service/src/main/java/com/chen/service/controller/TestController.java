package com.chen.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:TestController
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/24 00:13
 * @Version: v1.0
 */
@RestController
public class TestController {

    @RequestMapping("/service/test")
    public Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("test","test");
        return map;
    }
}
