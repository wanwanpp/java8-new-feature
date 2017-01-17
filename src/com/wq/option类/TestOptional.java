package com.wq.option类;

import java.util.Optional;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class TestOptional {

    /**
     * javadoc对Optional的描述如下
     * 这是一个可以为null的容器对象，如果存在（即非空）则isPresent（）方法会返回true
     * 调用get（）方法会返回该对象。
     * @param args
     */
    public static void main(String[] args) {

        Integer value1 = null;
//        Integer value1 = 6;
        Integer value2 = new Integer(5);

        Optional<Integer> a = Optional.ofNullable(value1);

        Optional<Integer> b = Optional.of(value2);
        System.out.println(sum(a,b));

    }

    public static Integer sum(Optional<Integer> a,Optional<Integer> b){
        System.out.println("first number is present: "+a.isPresent());
        System.out.println("second number is present: "+b.isPresent());

        Integer value1 = a.orElse(new Integer(0));

        Integer value2 = b.get();
        return value1+value2;
    }
}
