package com.sk.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * 自定义泛型类
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/12 12:36
 * @Version 1.0
 */
public class Order<T> {
    private String orderName;
    private int orderAge;
    private T orderT;

    public Order(){

    }

    public Order(String orderName, int orderAge, T orderT) {
        this.orderName = orderName;
        this.orderAge = orderAge;
        this.orderT = orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderAge=" + orderAge +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderT) {
//        System.out.println(orderT);
//    }
    public void show(){
        //编译不通过
//        try{
//
//        }catch(T t){
//
//        }
    }

    //泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法：可以声明为金静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定的
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
