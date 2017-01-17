package com.wq.时间API;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("current date and time :" + localDateTime);

        Month month = localDateTime.getMonth();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int second = localDateTime.getSecond();
        System.out.println("month: " + month + " day " + dayOfMonth + " second " + second);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("local date:" + localDate);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("local time:" + localTime);

        //由当前时间附带输入的年月日
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10).withMonth(3).withYear(2012);
        System.out.println("date 2 :" + localDateTime1);

        LocalDate localDate1 = LocalDate.of(2016, Month.DECEMBER, 26);
        System.out.println("date 3 " + localDate1);

        LocalTime time = LocalTime.of(19, 45, 58);
        System.out.println("date4 " + time);

        LocalDateTime localDateTime2 = LocalDateTime.of(localDate1, time);
        System.out.println("由localdate和localtime构造的localdatetime is " + localDateTime2);

        // 转化为字符串，再输出
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date 5: " + date5);
    }
}
