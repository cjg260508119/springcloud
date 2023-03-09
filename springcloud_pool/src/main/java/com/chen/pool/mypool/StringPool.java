package com.chen.pool.mypool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @ClassName:StringPool
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/3 14:09
 * @Version: v1.0
 */
public class StringPool extends GenericObjectPool<String> {

    public StringPool(PooledObjectFactory<String> factory) {
        super(factory);
    }

    public StringPool(PooledObjectFactory<String> factory, GenericObjectPoolConfig<String> config) {
        super(factory, config);
    }
}
