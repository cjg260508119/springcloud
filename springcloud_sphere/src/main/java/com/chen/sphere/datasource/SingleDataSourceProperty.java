package com.chen.sphere.datasource;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName:SingleDataSourceProperty
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/26 19:57
 * @Version: v1.0
 */
@Data
@Accessors(chain = true)
public class SingleDataSourceProperty {

    /**
     * JDBC driver
     */
    private String driverClassName;

    /**
     * JDBC 数据库地址
     */
    private String url;

    /**
     * JDBC 用户名
     */
    private String userName;

    /**
     * JDBC 用户密码
     */
    private String password;
}
