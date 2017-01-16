package com.wq.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/15 0015.
 */
public class TestLambda3 {

    /**
     * 方法引用
     * @param args
     */
    public static void main(String[] args) {

        String[] names = {"peter","wangping","lisi","haha"};
        //Arrays类是用来操作数组的例如（排序和搜索）的各种方法
        List nameList = Arrays.asList(names);

        nameList.forEach(System.out::println);
    }
}
