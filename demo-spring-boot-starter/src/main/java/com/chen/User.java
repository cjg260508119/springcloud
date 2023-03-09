package com.chen;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:User
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/23 15:45
 * @Version: v1.0
 */
@Configuration
@ConfigurationProperties(prefix="user")
@Data
public class User {

    private String id;

    private String name;
}
