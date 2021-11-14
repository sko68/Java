package com.sk.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/10 13:12
 * @Version 1.0
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));

        //for(集合元素类型 局部变量：集合对象)
        //内部器仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        //for(数组元素类型 局部变量：数组)
        int[] arr = new int[]{1, 5, 6, 5, 6};
        for (Object obj : arr) {
            System.out.println(obj);
        }
    }
    @Test
    public void test3(){
        String[] arr = new String[]{"MM", "MM", "MM"};
        //方式一：普通for循环
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//
//        }
        //方式二：增强for循环
        for (String s : arr) {
            s = "GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
