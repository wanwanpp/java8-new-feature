package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestMapAndReduce {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }

    // 使用lambda表达式

        System.out.println("使用lambda和map方法");
        costBeforeTax.stream().map(x->x+0.12*x).forEach(System.out::println);
    }
}
