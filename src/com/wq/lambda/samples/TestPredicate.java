package com.wq.lambda.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class TestPredicate {
    public static void main(String args[]){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);
    }

    /**
     * 遍历时进行筛选
     * @param names
     * @param condition
     */
    public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    /**
     * 先使用流进行筛选，再进行遍历
     * @param names
     * @param predicate
     */
    public static void filter2(List<String> names,Predicate<String> predicate){
        names.stream().filter((name)->(predicate.test(name))).forEach(System.out::println);
    }
}
