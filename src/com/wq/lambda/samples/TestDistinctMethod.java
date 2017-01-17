package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestDistinctMethod {

    /**
     * 流的distinct方法可以对集合进行去重。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 4, 1, 5, 6, 10);
        List<Integer> collect = list.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", list, collect);
    }
}
