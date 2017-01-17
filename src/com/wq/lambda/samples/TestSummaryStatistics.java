package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestSummaryStatistics {


    /**
     * IntStream、LongStream 和 DoubleStream 等流的类中，
     * 有个非常有用的方法叫做 summaryStatistics() 。
     * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，
     * 描述流中元素的各种摘要数据
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        IntSummaryStatistics statistics = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        //元素总数
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());

    }
}
