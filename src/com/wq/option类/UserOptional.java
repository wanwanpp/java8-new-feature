package com.wq.option类;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class UserOptional {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1l);
        user1.setName("WangPing");

        User user2 = new User();
        user2.setId(2l);
        user2.setName("WuQiong");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Optional<List<User>> userListOption = Optional.of(userList);
        userListOption.ifPresent(System.out::println);

        Optional<User> user = Optional.of(user1);
        user.ifPresent(System.out::println);

        Optional<String> s = Optional.ofNullable(user.map(u -> u.getName()).map(name -> name.toUpperCase()).orElse(null));
        System.out.println(s.get());


    }

}
