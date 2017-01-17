package com.wq.时间API;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by 王萍 on 2017/1/17 0017.
 */
public class TestTimePeriod {

    /**
     * 处理时间段
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获得当前的日期
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        // 在当前日期的基础上增加一个月时间
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date2);

        // 用between方法计算两个日期直接的间隔（称之为Period）
        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);

        LocalTime time1 = LocalTime.now();
        Duration fiveHours = Duration.ofHours(5);

        LocalTime time2 = time1.plus(fiveHours);

        // 对应的，用between方法显示两个时间直接的间隔（称之为Duration）
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);
    }
}
