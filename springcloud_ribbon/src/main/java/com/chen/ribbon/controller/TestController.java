package com.chen.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        return restTemplate.getForObject("http://service/service/test", Map.class);
    }
}
