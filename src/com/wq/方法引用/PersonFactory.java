package com.wq.方法引用;

import java.util.function.Supplier;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class PersonFactory {

    private Supplier<Person> supplier;

    public Person getPerson(){
        return supplier.get();
    }

    public PersonFactory(Supplier<Person> supplier){
        this.supplier=supplier;
    }
}
