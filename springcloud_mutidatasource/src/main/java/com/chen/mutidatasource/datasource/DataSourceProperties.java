package com.chen.mutidatasource.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName:DataSourceProperties
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/26 19:55
 * @Version: v1.0
 */
@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
@Data
public class DataSourceProperties {
    /**
     * 配置前缀
     */
    public static final String PREFIX = "mall.datasource.dynamic";

    /**
     * master数据源配置前缀
     */
    public static final String MASTER_PREFIX = "mall.datasource.dynamic.master";

    /**
     * slave数据源配置前缀
     */
    public static final String SLAVE_PREFIX = "mall.datasource.dynamic.slave";

    /**
     * 设置默认数据库, 默认master
     */
    public String primary = "master";

    /**
     * 设置启用数据源, 默认true
     */
    public boolean enabled = true;

    /**
     * 主数据源
     */
    public SingleDataSourceProperty master;

    /**
     * 从数据源
     */
    public SingleDataSourceProperty slave;
}
