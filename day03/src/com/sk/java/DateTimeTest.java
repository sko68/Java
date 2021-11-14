package com.sk.java;

import org.junit.Test;

import java.util.Date;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 15:42
 * @Version 1.0
 */
public class DateTimeTest {
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    /**
     *java.util.Date类
     *      |--java.sql.Date类
     *
     * 1.两个构造器的使用
     *
     * 2.两个方法的使用
     *      >toString():显示当前的年月日时分秒
     *      >getTime():获取当前Date对象对应的毫秒数
     *
     * 3.java.sql.Date对应着数据库中的日期·类型的变量
     *      >如何实例化
     *      >java.sql.Date --> java.util.Date
     */
    @Test
    public void test2(){
        //构造器一 ：Date();  创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        date1.getTime();

        //构造器二:创建指定毫秒的Date对象
        Date date2 = new Date(1655555555585L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(555555555555L);
        System.out.println(date3);

        //如何将java.sql.Date --> java.util.Date

        Date date6 = new Date();
        java.util.Date date7 = new java.sql.Date(date6.getTime());
    }
}
