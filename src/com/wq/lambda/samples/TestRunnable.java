package com.wq.lambda.samples;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class TestRunnable {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha,wangping nihao");
            }
        }).start();

        new Thread(()-> System.out.println("java8 中 lambda运行")).start();
    }
}
