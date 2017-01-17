package com.wq.方法引用;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class Person {

    public Person(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compare(Person p1,Person p2){
        return p1.getName().compareTo(p2.getName());
    }

    public int compareTo(Person p){
        return this.getName().compareTo(p.getName());
    }
}
