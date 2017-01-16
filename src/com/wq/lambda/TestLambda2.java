package com.wq.lambda;

/**
 * Created by 王萍 on 2017/1/15 0015.
 */
public class TestLambda2 {


    /**
     * 通过使用Lambda表达式，你可以引用final变量或者有效的final变量
     * （只赋值一次）。如果一个变量被再次赋值，Lambda表达式将抛出一个编译错误。
     */

    private final static String STRING="HELLO ";
    public static void main(String[] args) {

        GreetingService greetingService = message -> System.out.println(STRING+message);

        greetingService.sayMessage("wangping");
    }
}
