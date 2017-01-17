package com.wq.stream流;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());

        /**
         * filter方法用于过滤满足条件的元素
         * parallelStream获取并行流
         */
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij", "", "lmn");
        System.out.println(strings.stream().filter(s -> !s.isEmpty()).count());
        System.out.println(strings.parallelStream().filter(s -> !s.isEmpty()).count());


        /**
         * Collector用于合并stream返回的元素处理结果
         */
        List<String> stringList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered list is :" + stringList);
        String mergedString = strings.parallelStream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("merged string is:" + mergedString);


        /**
         * 统计工具，统计数据
         */
        List<Integer> integers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        /**
         * 一对多的操作
         * flatmap的作用是层级结构扁平化，就是将最底层的元素抽出来放在一起。
         */
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 5));
        Stream<Integer> outputStream = inputStream.flatMap(children -> children.stream());
        outputStream.sorted().distinct().forEach(System.out::println);

        /**
         * peek方法的使用，对每个元素进行操作并返回一个新的stream
         * 从这里就可以看出，stream的处理过程是对所有处理函数进行集合，然后一次遍历对每个元素进行操作
         */
        Stream.of("one", "two", "three", "fou")
                .filter(s -> s.length() == 3)
                .peek(s -> System.out.println("filtered value is:" + s))
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println("转化为大写：" + s))
                .map(String::toLowerCase)
                .peek(s -> System.out.println("转化为小写：" + s))
                .collect(Collectors.toList());

        /**
         * reduce方法的主要功能就是把stream的元素组合起来。
         * 它提供一个起始值种子，然后根据运算规则（BinaryOperator），和前面stream中的第一个，第二个，第三个，第n个元素就是组合
         * 例如加减乘除运算法，字符拼接等。
         */
        //第一个参数是空字符，第二个参数是一个二元操作BinaryOperator接口，也是一个函数式接口。
        System.out.println(Stream.of("A", "B", "C", "D").reduce("", String::concat));
        System.out.println(Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b));

        //这里调用的reduce方法中没有第一个初始值种子参数，就可能出现返回为空的情况，因此返回值为Optional类型的
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());
        System.out.println(Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat));


    }
}
