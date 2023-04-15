package com.chen.annotation.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:MyConfiguration
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/15 17:21
 * @Version: v1.0
 */
@Configuration
@ConfigurationProperties(prefix = "config.test")
@Data
public class MyConfiguration {

    private String myval;
}
