package com.wq.stream流;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class SimpleSample {

    public static void main(String[] args) {

        /**
         * forEach操作用于对stream中的每个元素进行迭代操作
         * limit方法用于限制大小
         * sorted方法从小到大排序
         */
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);
//        random.ints().limit(10).sorted().forEach(System.out::println);


        /**
         * map方法用于将每个元素映射到对应的结果上
         * distinct是在stream中对集合进行去重
         */
        List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        /**
         * filter方法用于过滤满足条件的元素
         * parallelStream获取并行流
         */
        List<String>strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        System.out.println(strings.stream().filter(s -> !s.isEmpty()).count());
        System.out.println(strings.parallelStream().filter(s -> !s.isEmpty()).count());


        /**
         * Collector用于合并stream返回的元素处理结果
         */
        List<String> stringList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered list is :"+stringList);
        String mergedString = strings.parallelStream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("merged string is:"+mergedString);


        /**
         * 统计工具，统计数据
         */
        List<Integer> integers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
