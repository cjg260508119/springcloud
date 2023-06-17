package com.chen.ribbonold.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 26050
 * @Date 2023/6/11 18:16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/ribbonold/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/test")
    public String test(){
        restTemplate.getForObject("http://ribbontest/ribbon/test", String.class);
        return "test";
    }
}
