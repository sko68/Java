package com.sk.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: jdk 8之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/7 9:54
 * @Version 1.0
 */
public class DateTimeTest {
    /**
    SimpleDateFormat的使用：SmpleDateFormat对日期Date类的格式化和解析

     两个操作
     1.格式化： 日期  -->字符串
     2.解析:  格式化的逆过程

     SimpleDateFormat的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化： 日期  -->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析 格式化的逆过程
        String str = "2021/11/7 上午10:15";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        System.out.println("**********按照指定方式格式化和解析:调用带参构造器***********");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = sdf.format(date);
        System.out.println(format1);

        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数实现)
        Date date2 = sdf1.parse("2020-10-15 20:12:11");
        System.out.println(date);

    }
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    //calendar日历类(抽象类)
    //1.实例化
    //方式一：创建其子类（GregorianCalendar)的对象
    //方式二：调用其静态方法getIntance()
    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_YEAR,45);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //add()

        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);
        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

    }
}
