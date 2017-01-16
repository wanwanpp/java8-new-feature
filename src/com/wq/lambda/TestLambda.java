package com.wq.lambda;

/**
 * Created by 王萍 on 2017/1/15 0015.
 */
public class TestLambda {

    public static void main(String[] args) {

        TestLambda testLambda = new TestLambda();
        MathOperation addtion = (int a, int b) -> a + b;
        MathOperation substration = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = "+testLambda.operate(10,5,addtion));
        System.out.println("10 - 5 = "+testLambda.operate(10,5,substration));
        System.out.println("10 * 5 = "+testLambda.operate(10,5,multiplication));
        System.out.println("10 / 5 = "+testLambda.operate(10,5,division));

        GreetingService greetingService1 = message -> System.out.println("message is "+message);
        GreetingService greetingService2 = (message)->{
            System.out.println("message is "+message);
        };

        greetingService1.sayMessage("wangping");
        greetingService2.sayMessage("wanwanpaopao");

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
