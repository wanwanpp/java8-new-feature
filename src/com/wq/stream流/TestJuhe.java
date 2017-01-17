package com.wq.stream流;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestJuhe {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\IDEA\\java8\\src\\com\\wq\\stream流\\catalina.2016-03-31.log"));
        //lines()函数返回的是stream对象
        //获取总行数
        System.out.println(bufferedReader.lines().count());
        //打印每一行的字符总数
        bufferedReader.lines().mapToInt(String::length).forEach(System.out::println);
        //打印字符数最多是多少
//        int longest = bufferedReader.lines().mapToInt(String::length).max().getAsInt();
        bufferedReader.close();
//        System.out.println(longest);
    }

    @Test
    public void test() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\IDEA\\java8\\src\\com\\wq\\stream流\\catalina.2016-03-31.log"));
        List<String> stringList = bufferedReader.lines().flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.length() > 0)
                .map(String::toLowerCase)
                .distinct()
                .sorted((word1, word2) -> (word1.compareTo(word2)))
                .collect(Collectors.toList());
        bufferedReader.close();
        System.out.println(stringList);

    }
}
