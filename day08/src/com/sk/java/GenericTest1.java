package com.sk.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 * 1、关于自定义泛型类、泛型接口
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/12 12:44
 * @Version 1.0
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order("orderAA", 1001, "order:AA");
        order.setOrderT("AA:hello");

        //建议实例化时指明类的泛型
        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");
        order1.setOrderT("AA:hello");

    }
    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承父类时，，指明了泛型类型。则实例化子类对象时，，不再需要指明泛型
        subOrder.setOrderT(234);
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("subOrder1...");

    }
    @Test
    public void test3(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();
        //泛型不同的引用不能相互赋值
//        list1 = list2;
        Person p1 = null;
        Person p2 = null;
        p1 = p2;


    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }

}
