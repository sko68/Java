package com.sk.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 涉及到String类与其他结构之间的转换
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 12:23
 * @Version 1.0
 */
public class StringTest1 {
    //复习:与基本数据类型、包装类之间的转换
//    String -->基本数据类型、包装类：调用包装类的静态方法：parssXxx(str)
    //基本数据类型、包装类 -->String 调用String重载的valueOf(xxx)
    @Test
    public void test1(){
        String str = "123";
        int num = Integer.parseInt(str);
        String str2 = String.valueOf(num);
        String str3 = num + "";
    }

    //String 与 char[]之间的转换
//    String -->char[];  调用String的toCharArray();
//    char[]  --> String :调用String的构造器
    @Test
    public void test(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0;i < charArray.length;i++){
            System.out.println(charArray[i]);
        }
        char[] arr = new char[]{'h','e','e','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
    //String 与 byte[]之间的转换
//    String --> byte[]; 调用String的getBytes()
    @Test
    public void test3(){
        String str1 = "abc123";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));


    }

}
