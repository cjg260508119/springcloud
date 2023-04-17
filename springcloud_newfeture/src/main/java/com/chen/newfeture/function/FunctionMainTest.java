package com.chen.newfeture.function;

import java.util.function.Function;

/**
 * @ClassName:FunctionMainTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/16 20:36
 * @Version: v1.0
 */
public class FunctionMainTest {

    interface FunctionTest<T>{
        public void print(T t);
    }

    public static void test(String s, FunctionTest<String> fun){
        fun.print(s);
    }

    public static void test2(String s, Function<String, String> fun){
        fun.apply(s);
    }

    public static void main(String[] args){
        FunctionMainTest.test("haha", s->{System.out.println(s);});

        FunctionMainTest.test("test", s->{System.out.println(s);});
    }
}
