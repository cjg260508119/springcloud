package com.chen.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName:MainTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/3 00:28
 * @Version: v1.0
 */
public class MainTest {

    //static JedisPool pool = new JedisPool("localhost", 26380, "default", "Cjg260508119");
    /*static{
        pool.set
    }*/


    public static void main(String[] args) {
        send();
    }

    public static void send(){
        JedisPool pool = new JedisPool("localhost", 26380, "default", "Cjg260508119");
        //pool.setMaxIdle(100000);
        try (Jedis jedis = pool.getResource()) {
            //jedis.set("clientName", "Jedis");
            //System.out.println(jedis.get("clientName"));
            jedis.bitfield("bitf", "01010010101");
        }


    }
}
