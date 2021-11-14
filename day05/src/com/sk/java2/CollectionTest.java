package com.sk.java2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @Description: TODO
 * 一、集合框架概述
 * 1.集合，数组都说对多个数据进行存储操作的结构，简称Java容器
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 *
 * 2.1.数组存储多个数据方面的特点：
 *      >一旦初始化以后，长度就确定了
 *      >数组一旦定义好，其元素的类型也就确定了，就只能操作指定类型的数据了，比如：String[] arr;
 * 2.2数组在存储多个数据方面的缺点
 *      >一旦初始化后，长度不可变
 *      >数组中提供的方法非常有限，对于添加，修改，删除数据操作不便，效率低
 *      >获取数组中实际元素的个数的需求，没有现成的方法或属性可用
 *      >数组存储数据的特点：有序、可重复，对于无需不可重复的需求不能满足
 *
 * 二、集合的框架
 *      |----Collection接口，单列集合，用来存储一个一个的对象
 *          |----list接口  存储有序的，可重复的数据  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口   存储无序的，不可重复的数据
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *
 *      |----Map接口. 双列集合，用来存储一对（key - value)一对数据
 *          |---HashMap、LinkedHashMap、TreeMap、hashTable、Properties
 * 三、Collection接口中的方法的使用
 *
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/9 19:35
 * @Version 1.0
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);  //自动装箱·
        coll.add(new Date());

        //size()  //获取添加的元素的个数
        System.out.println(coll.size());

        //addAll():将另一个集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        //isEmpty() : 判断当前集合是否为空
        System.out.println(coll.isEmpty());

        //clear()清空集合
        coll.clear();

        System.out.println(coll.isEmpty());



    }
}
