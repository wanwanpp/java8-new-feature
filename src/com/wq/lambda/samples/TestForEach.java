package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class TestForEach {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("wangping", "wuqiong", "zhangyao");
        System.out.println("java8之前");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        System.out.println("java8之后");
        names.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("方法引用");
        names.forEach(System.out::println);
    }
}
