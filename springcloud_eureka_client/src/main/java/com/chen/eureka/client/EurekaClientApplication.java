package com.chen.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName:EurekaServerApplication
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/23 21:13
 * @Version: v1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run( EurekaClientApplication.class, args );
    }
}
