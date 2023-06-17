package com.chen.ribbonold.http;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:HttpClientPoolConfig
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/24 11:36
 * @Version: v1.0
 */
@ConfigurationProperties(prefix = "http")
@Configuration
@Data
public class HttpClientPoolConfig {

    @Value("${maxTotalConnect:10}")
    private int maxTotalConnect;

    @Value("${maxConnectPerRoute:10}")
    private int maxConnectPerRoute;

    @Value("${connectTimeout:5}")
    private int connectTimeout;

    @Value("${readTimeout:5}")
    private int readTimeout;

    @Value("${connectionRequestTimout:5}")
    private int connectionRequestTimout;
}
