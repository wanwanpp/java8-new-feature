package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestFilterString {

    /**
     * 流提供一个filter（）方法，接受一个Predicate对象
     * 在之前的方法中，做过滤操作时，通常会丢失部分数据，
     * 但使用filter是获得一个新的列表，且每个元素符合过滤原则
     * @param args
     */

    public static void main(String[] args) {
        List<String> origin = Arrays.asList("abc","bcd","ds","poi");
        List<String> newString = origin.stream().filter(n->n.length()==3).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", origin, newString);
    }
}
