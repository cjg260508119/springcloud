package com.chen.gctest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 26050
 * @Date 2023/5/12 19:51
 * @Version 1.0
 */
public class TestGC {

    public static void main(String[] args) {
        //byte[] b = new byte[1024 * 1024];
        List<byte[]> l = new ArrayList<>();
        for(int i=0; i<100; i++){
            byte[] b = new byte[1024 * 1024];
            l.add(b);
        }
        System.out.println("test");
    }
}
