package com.wq.函数式接口.default方法;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class DefaultMethod {

    /**
     * 默认方法允许你将新的功能（即新的函数）添加到已有的类的接口中，
     * 并能确保与采用旧版本接口编写的代码的二进制兼容性。
     *
     * 在java8之前，接口与实现类的耦合度太高了，当需要为一个接口添加新的方法时，需要对每个实现类进行修改。
     * 默认方法解决了这个问题，它可以为接口添加新的方法，而不会破坏已有接口的实现。
     * 为保持旧接口且保持向后兼容提供了途径。
     * 例如list的forEach方法就是后面通过java8 default方法在Iterable接口中添加的。
     * @param args
     */
    public static void main(String[] args) {


        Younger younger = new Student();
        younger.print();

        Learner learner = new Student();
        learner.print();
    }
}
