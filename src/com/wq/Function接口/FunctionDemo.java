package com.wq.Function接口;

import java.util.function.Function;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class FunctionDemo {


    /**
     * Function<Integer,Integer> function参数就是使用lambda定义的一个处理过程，就是一个函数。
     * 传入一个参数，应用某些规则，返回一个结果。至于是什么规则，一般是使用lambda表达式定义。
     * @param valueToBeOperated
     * @param function
     */
    static void modifyTheValue(int valueToBeOperated, Function<Integer,Integer> function){
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }

    public static void main(String[] args) {

        int number = 10;
        modifyTheValue(number,value->value+10);
        modifyTheValue(number,value->value*10);
        modifyTheValue(number,value->value-10);
        modifyTheValue(number,value->{
            if (value>20){
                return 100;
            }else {
                return 200;
            }
        });

    }
}
