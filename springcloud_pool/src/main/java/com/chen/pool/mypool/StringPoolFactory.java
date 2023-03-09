package com.chen.pool.mypool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @ClassName:StringPoolFactory
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/3 14:05
 * @Version: v1.0
 */
public class StringPoolFactory extends BasePooledObjectFactory<String> {

    @Override
    public String create() throws Exception {
        return "str-val-";
    }

    @Override
    public PooledObject<String> wrap(String obj) {
        return new DefaultPooledObject<>(obj);
    }

}
