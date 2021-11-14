package com.sk.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Description: jdk8中日期时间API的测试
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/8 10:35
 * @Version 1.0
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 10);
        System.out.println(date1);
    }

    //localDate localTime local
    @Test
    public void test1(){
        //now()：获取当前日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定年月日时分秒,没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 3, 23, 56, 45);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //WithXxx():设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withMonth(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(5);
        System.out.println(localDateTime3);

        //不可变性
        LocalDateTime localDateTime4 = localDateTime.plusMonths(2);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusDays(10);
        System.out.println(localDateTime5);


    }

    //Instant的使用
    //类似于java.util.Date类
    @Test
    public void test2(){

        //now()获取本初子午线对应的标准时间
        Instant instance = Instant.now();
        System.out.println(instance);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instance.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取1970年1月1日0时0分0秒 开始的毫秒数   <-->  类似于Date类的getTime();
        long milli = instance.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant = Instant.ofEpochMilli(1636342177160L);
        System.out.println(instant);
    }

    /**
     * DateTimeFormatter：格式化或解析日期时间
     * 类似于SimpleDateformat
     */
    @Test
    public void test3(){
        //方式一：预定义的格式标准 如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析:字符串 -->日期
        TemporalAccessor parse = formatter.parse("2021-11-08T13:53:47.901014300");
        System.out.println(parse);

        //方式二:
//      本地化相关的格式。如ofLocalizedDateTime()
//      FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

//      本地化相关的格式。如：ofLocalizedDate()
//       FormatStyle.FULL/ FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        //格式化
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str3 = formatter2.format(LocalDateTime.now());
        System.out.println(str3);


        //重点:方式三:自定义的格式，如：ofPattern("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor parse1 = formatter3.parse("2020-02-08 03:34:23");
        System.out.println(parse1);


    }



}

