package com.chen.mutidatasource.datasource;



import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:DynamicDataSource
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/26 20:38
 * @Version: v1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 使用线程切换数据源
     */
    private static ThreadLocal<String> contextHandler = new ThreadLocal<>();
    /**
     * 数据源key集合
     */
    private static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 配置数据源
     *
     * @param defaultDataSource   主数据源
     * @param targetDataSourceMap 其他数据源集合
     */
    public DynamicDataSource(DataSource defaultDataSource, Map<Object, Object> targetDataSourceMap) {
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(targetDataSourceMap);
        super.afterPropertiesSet();
        // 初始化所有数据源的key
        addAllDataSourceKeys(targetDataSourceMap.keySet());
    }

    public static void setDataSourceKeys(String key) {
        contextHandler.set(key);
    }

    public static ThreadLocal<String> getDataSourceKeys() {
        return contextHandler;
    }

    public static void removeDataSourceKeys() {
        contextHandler.remove();
    }

    public static boolean containsDataSourceKeys(String key) {
        return dataSourceKeys.contains(key);
    }

    public static boolean addAllDataSourceKeys(Collection<? extends Object> keys) {
        return dataSourceKeys.addAll(keys);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHandler.get();
    }
}
