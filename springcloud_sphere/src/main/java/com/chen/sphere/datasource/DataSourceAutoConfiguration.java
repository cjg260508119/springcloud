package com.chen.sphere.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:DataSourceAutoConfiguration
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/26 20:10
 * @Version: v1.0
 */
@Slf4j
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(DataSourceProperties.class)
@ConditionalOnProperty(prefix = DataSourceProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class DataSourceAutoConfiguration {

    private final DataSourceProperties dataSourceProperties;

    /**
     * 主数据源(这里配置写的繁琐一点, 可根据个人喜好进行简化.)
     *
     * @return DataSource
     */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(DataSourceProperties.MASTER_PREFIX)
    public DataSource masterDataSource() {
        SingleDataSourceProperty master = dataSourceProperties.master;
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setName(DataSourceConstants.MASTER);
        druidDataSource.setDriverClassName(master.getDriverClassName());
        druidDataSource.setUrl(master.getUrl());
        druidDataSource.setUsername(master.getUserName());
        druidDataSource.setPassword(master.getPassword());
        return druidDataSource;
    }

    /**
     * 从 数据源(这里配置写的繁琐一点, 可根据个人喜好进行简化.)
     *
     * @return DataSource
     */
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(DataSourceProperties.SLAVE_PREFIX)
    @ConditionalOnProperty(prefix = DataSourceProperties.SLAVE_PREFIX, name = "enabled", havingValue = "true")
    public DataSource slaveDataSource() {
        SingleDataSourceProperty slave = dataSourceProperties.slave;
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setName(DataSourceConstants.SLAVE);
        druidDataSource.setDriverClassName(slave.getDriverClassName());
        druidDataSource.setUrl(slave.getUrl());
        druidDataSource.setUsername(slave.getUserName());
        druidDataSource.setPassword(slave.getPassword());
        return druidDataSource;
    }

    /**
     * 动态数据源
     *
     * @return DynamicDataSource
     */
    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> targetMap = new HashMap<>(2);
        targetMap.put(DataSourceConstants.MASTER, masterDataSource());
        targetMap.put(DataSourceConstants.SLAVE, slaveDataSource());
        DynamicDataSource dynamicDataSource = new DynamicDataSource(masterDataSource(), targetMap);
        log.info("动态数据源装配完成...");
        return dynamicDataSource;
    }
}
