package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestMapAndReduce2 {

    /**
     * reduce 又被称为折叠操作
     * 它接收多个值并返回一个值
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

// 新方法：

        double bill = costBeforeTax.stream().map(c->c+0.12*c).reduce((sum,cost)->sum+cost).get();
        System.out.println(bill);

    }
}
