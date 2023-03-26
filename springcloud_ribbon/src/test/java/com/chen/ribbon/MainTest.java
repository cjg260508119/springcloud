package com.chen.ribbon;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName:MainTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/17 10:52
 * @Version: v1.0
 */
public class MainTest {

    public static void main(String[] args){
        /*Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> set =  map.keySet();
        for(Thread t : set){
            StackTraceElement[] eles = map.get(t);
            for(StackTraceElement ele : eles){
                System.out.println(ele.getMethodName());
            }
        }
        System.out.println(map);*/
        Test t = new Test();
        t.foo();
    }

    static class Test {
        static ObjectHolder oh = new ObjectHolder();
        ObjectHolder instance = new ObjectHolder();

        void foo(){
            ObjectHolder ohin = new ObjectHolder();
            System.out.println("donw");
        }
    }
}
