package com.chen.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:TestController
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/24 00:15
 * @Version: v1.0
 */
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon/test")
    public Map<String,String> test(){

        /*Map<String, String> map = new HashMap<>();
        map.put("test","test");
        return map;*/

        return restTemplate.getForObject("http://ribbonold/ribbonold/test/test", Map.class);
    }
}
