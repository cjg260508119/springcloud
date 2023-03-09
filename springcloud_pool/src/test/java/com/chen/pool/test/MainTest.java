package com.chen.pool.test;

import com.chen.pool.mypool.StringPool;
import com.chen.pool.mypool.StringPoolFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.time.Duration;

/**
 * @ClassName:MainTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/3 13:59
 * @Version: v1.0
 */
public class MainTest {

    public static void main(String[] args) {
        StringPoolFactory fac = new StringPoolFactory();
        GenericObjectPoolConfig<String> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(2);
        config.setMinIdle(1);
        //config.setMaxWaitMillis(3000);
        Duration duration = Duration.ofMillis(3000);
        config.setMaxWait(duration);
        StringPool pool = new StringPool(fac, config);
        for (int i = 0; i < 3; i++) {
            String s = "";
            try {
                s = pool.borrowObject();
                System.out.println(s);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                if (!s.equals("")) {
//                    pool.returnObject(s);
//                }
            }
        }
    }
}
