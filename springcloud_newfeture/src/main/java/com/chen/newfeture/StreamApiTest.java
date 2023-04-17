package com.chen.newfeture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName:StreamApiTest
 * @Auther: 26050
 * @Description:流处理api的使用
 * @Date: 2023/4/16 16:30
 * @Version: v1.0
 */
public class StreamApiTest {

    public static void main(String[] args){
        StreamApiTest.sort();
    }

    public static void sort(){
        //没用java8特性
        List<Apple> lst = new ArrayList<>();
        Apple apple1 = new Apple(5);
        Apple apple2 = new Apple(2);
        lst.add(apple1);
        lst.add(apple2);
        Collections.sort(lst, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(lst);

        //使用java8新特性
        lst = new ArrayList<>();
        apple1 = new Apple(8);
        apple2 = new Apple(5);
        lst.add(apple1);
        lst.add(apple2);
        lst.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(lst);
    }
}
