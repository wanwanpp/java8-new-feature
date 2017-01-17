package com.wq.option类;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */

/**
 * 关于在Optional中已经有了ofNullable方法还定义了of方法的原因
 * 我本人的观点是:
 * 1. 当我们非常非常的明确将要传给 Optional.of(obj) 的 obj 参数不可能为 null 时,
 * 比如它是一个刚 new 出来的对象(Optional.of(new User(...))), 或者是一个非 null 常量时;
 * 2. 当想为 obj 断言不为 null 时, 即我们想在万一 obj 为 null
 * 立即报告 NullPointException 异常, 立即修改, 而不是隐藏空指针异常时,
 * 我们就应该果断的用 Optional.of(obj) 来构造 Optional 实例,
 * 而不让任何不可预计的 null 值有可乘之机隐身于 Optional 中.
 */
public class Optional常用方法示例 {

    public static void main(String[] args) {

        /**
         * of()方法通过工厂方法创建Optional类，但是传入的参数不能为null，否则会抛出空指针异常。
         */
        Optional<String> name = Optional.of("wangping");
//        Optional<String> isnull = Optional.of(null);

        /**
         * 与of方法唯一的区别就是可以接受null的情况。
         */
        Optional empty = Optional.ofNullable(null);

        /**
         * isPresent（）如果存在则返回true，否则返回false。
         */
        if (name.isPresent()) {
            System.out.println(name.get());
        }

        /**
         * get()方法，如果Optional有值则将其返回，没有就抛出NoSuchElementException异常。
         */
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException no) {
            System.out.println(no.getMessage());
        }

        /**
         *  如果Optional类有值则为其调用Consumer，否则不处理。
         */
        name.ifPresent(value -> System.out.println("the length is " + value.length()));
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
        name.ifPresent(System.out::println);

        /**
         * 如果值不为0，则返回Optional实例的值，如果为null，则返回传入的参数。
         */
        System.out.println(name.orElse("返回其他值"));
        System.out.println(empty.orElse("返回其他值"));

        /**
         * 与orElse（）方法类似
         * 区别在于orElse接受的是默认值，而orElseGet接受的是一个lambda表达式生成的默认值。
         * 比orElse更加灵活。
         */
        System.out.println(empty.orElseGet(() -> "新生成的值"));
        System.out.println(name.orElseGet(() -> "新生成的值"));
        System.out.println(empty.orElseGet(() -> {
            int i = 0;
            if (i != 0) {
                System.out.println("i不等于0");
            } else {
                System.out.println("i等于0");
            }
            return 1;
        }));

        try {
            //orElseThrow与orElse方法类似。与返回默认值不同，
            //orElseThrow会抛出lambda表达式或方法生成的异常
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            //输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }

        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println(upperName.orElse("No value found"));

        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        Optional<String> upperName2 = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));


        Optional<String> loginName = name.filter(value -> value.length() > 6);
        System.out.println(loginName.orElse("长度小于6"));
        Optional<String> loginName2 = Optional.of("haha").filter(value -> value.length() > 6);
        //若不满足断言，则不满足的元素会被过滤掉。
        System.out.println(loginName2.orElse("长度小于6"));


        /**
         *
         *
         * 一下列举几个适用的方法使用习惯
         *
         *
         *  1.return user.orElse(null);
         *  而不是 return user.isPresent() ? user.get() : null;
         *  return user.orElse(UNKNOWN_USER);
         *
         *  2.return user.orElseGet(() -> fetchAUserFromDatabase());
         *  而不要 return user.isPresent() ? user: fetchAUserFromDatabase();
         *
         *  3.user.ifPresent(System.out::println);
         *  而不要下边那样
         *  if (user.isPresent()) {
         *  System.out.println(user.get());
         *  }
         */


    }
}
