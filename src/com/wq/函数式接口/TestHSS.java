package com.wq.函数式接口;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 王萍 on 2017/1/15 0015.
 */
public class TestHSS {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        System.out.println("All number is :");
        process(list,n->true);

        System.out.println("Even number is：");
        process(list,n->n%2==0);

        System.out.println("number which is greater than 3");
        process(list,n->n>3);
    }

    public static void process(List<Integer> list, Predicate<Integer> predicate){
        for (int n:list){
            if (predicate.test(n)){
                System.out.println(n+" ");
            }
        }
    }
}
