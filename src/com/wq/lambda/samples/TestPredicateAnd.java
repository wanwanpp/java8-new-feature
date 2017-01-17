package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestPredicateAnd {
    public static void main(String[] args) {

        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入


        Predicate<String> startWithW = n -> n.startsWith("W");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        List<String> names = Arrays.asList("wang", "qiong", "haha", "Wang", "Wong");
        names.stream().filter(startWithW.and(fourLetterLong)).forEach(System.out::println);
    }
}
