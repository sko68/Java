package com.sk.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: TODO
 * 1.List接口框架
 *      |----Collection接口，单列集合，用来存储一个一个的对象
 *          |----list接口  存储有序的，可重复的数据  -->“动态”数组，替换原有数组
 *              |----ArrayList  ：作为List接口的主要实现类，线程不安全，效率高，底层使用Object[]存储
 *              |----LinkedList ：对于频繁的插入、删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
 *              |----Vector ：作为List接口的古老实现类，线程安全的，效率低
 *
 * ArrayList的源码分析
 * 2.1 jdk7的情况
 * ArrayList list = new ArrayList();   //底层创建了长度是10的Object[]数组elementData存储
 * list.add(123); //elementDate[0] = new Integer(123);
 * ...
 * list.add(11);  //如果此次添加导致底层elementDate数组容量不够，则扩容
 * 默认情况下，扩容为原来的1.5倍，同时需要将原有数组中的数复制到新数组中。
 * 结论：建议开发中使用代参构造器：ArrayList list = new ArrayList（int capacity)
 *
 * 2.2jdk 8 中ArrayList的变化
 * ArrayList list = new ArrayList() ;//底层Object[] elementData初始化为{}。并没有创建长度为10的数组
 * list.add(123); //第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]中
 * ....
 * 后续的添加和扩展操作与jdk 7 无异
 *
 * 2.3小结：
 * jdk 7 中的ArrayList的对象的创建类似于单例模式的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例模式的懒汉式，延迟了数组的创建，节省了内存
 *
 * 3.LinkedList的源码分析
 * LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 * list.add(123); //将123封装到Node中，创建了Node对象
 *
 * 其中Node定义为：体现了LinkedList的1双向链表的说法
 * private static class Node<E>{
 *     E item;
 *     Node<E> next;
 *     Node<E> prev;
 *     Node(Node<E> prev,E element,Node<E> next){
 *     this.item = element;
 *     this.next = next;
 *     this.prev = prev
 *     }
 * }
 *
 * 4.Vector的源码分析:jdk7和jdk8中通过Vector构造器创建对象时，底层都创建了长度为10的数组，
 * 在扩容方面，默认扩容为原来数组长度的两倍
 *
 *面试题ArrayList、8LinkedList、Vector三者有何异同
 * 同：三者都实现了List接口，存储数据相同：有序的，可重复的
 * 异：见上
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/10 13:28
 * @Version 1.0
 */
public class ListTest {
    /**
     * List接口中的常用方法
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
     *
     *
     * 总结：常用方法
     * 增：add(Object obj)
     * 删：remove(int index)
     * 改：set(int index)
     * 查：get(int index)
     * 插：add(int index,obj)
     * 长度：size()
     * 遍历: ①Iterator迭代器方式
     * ②增强for循环
     * ③普通的for循环
     */



    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("Tom"));
        list.add(false);
        list.add(new Person("Jerry", 20));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele)
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll (int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));

    }
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(456);
        list.add(123);
        list.add(new String("Tom"));
        list.add(false);
        list.add(new Person("Jerry", 20));
        list.add(456);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = list.remove(2);
        System.out.println(remove);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        Object set = list.set(1, "CC");
        System.out.println(set);
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List list1 = list.subList(1, 3);
        System.out.println(list1);

    }
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(new String("Tom"));
        list.add(456);
        list.add(false);
        list.add(new Person("Jerry", 20));
        list.add(456);

        //方式一：Iterator迭代器
        Iterator iterator = list.iterator();
        while ((iterator.hasNext())) {
            System.out.println(iterator.next());
        }

        //方式二：增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }

        //方式三
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }









}
