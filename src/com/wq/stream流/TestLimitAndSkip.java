package com.wq.stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestLimitAndSkip {

    public static void main(String[] args) {

//        List<Person> persons = new LinkedList<>();
//        for (int i = 1;i<=10000;i++){
//            persons.add(new Person(i,"name"+i));
//        }
//        List<String> collect = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
//        System.out.println(collect);



//        List<Person> persons = new ArrayList();
//        for (int i = 1; i <= 5; i++) {
//            Person person = new Person(i, "name" + i);
//            persons.add(person);
//        }
//        //将skip，limit放在了sorted之后，会出现没起到限制数量的作用
//        List<Person> personList2 = persons.stream().sorted((p1, p2) ->
//                p1.getName().compareTo(p2.getName())).limit(2).collect(Collectors.toList());
//        System.out.println(personList2);


        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        //先进行限制后再排序，起到了作用
        List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(personList2);
    }

    private static class Person{
        public int no;
        private String name;

        public Person(int no,String name){
            this.no=no;
            this.name=name;
        }
        public String getName() {
            System.out.println(name);
            return name;
        }
    }
}
