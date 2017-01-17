package com.wq.default方法;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class Student implements Learner,Younger {

    /**
     * 当继承的接口中都有相同的default方法时，需要明确指定使用哪个接口的default方法
     */


    @Override
    public void print() {
        Younger.super.print();
        Learner.super.print();
        Younger.sayHello();
        System.out.println("I am a student..");
    }
}
