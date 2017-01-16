package com.wq.函数式接口.option类;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class Optional常用方法示例 {

    public static void main(String[] args) {

        /**
         * of()方法通过工厂方法创建Optional类，但是传入的参数不能为null，否则会抛出空指针异常。
         */
        Optional<String> name = Optional.of("wangping");
//        Optional<String> isnull = Optional.of(null);

        /**
         * 与of方法唯一的区别就是可以接受null的情况。
         */
        Optional empty = Optional.ofNullable(null);

        /**
         * isPresent（）如果存在则返回true，否则返回false。
         */
        if (name.isPresent()) {
            System.out.println(name.get());
        }

        /**
         * get()方法，如果Optional有值则将其返回，没有就抛出NoSuchElementException异常。
         */
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException no) {
            System.out.println(no.getMessage());
        }

        /**
         *
         */
        name.ifPresent(value -> System.out.println("the length is " + value.length()));
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
        name.ifPresent(System.out::println);
    }
}
