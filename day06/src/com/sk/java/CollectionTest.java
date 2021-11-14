package com.sk.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Description: Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据时，要求obj所在类重写
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/10 10:16
 * @Version 1.0
 */
public class CollectionTest {

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

        //1.contains(Object obj) :判断当前集合是否包含obj
        //判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(new Person("Jerry",20));

        //2.containAll() 判断形参coll中所有元素是否都存在与当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

    }
    @Test
    public void test2(){
        //3.remove(Object obj)  //从当前集合删除指定元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        coll.remove(1234);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);

        //4.removeAll(Object obj)  //从当前集合中移除指定集合中共有的元素
        Collection coll1 = Arrays.asList(123, 456, 2345);
        coll.removeAll(coll1);
        System.out.println(coll);

    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //5.retainAll(Object obj) //获取当前集合与指定集合中共有的元素
//        Collection coll1 = Arrays.asList(123, 456, 2345);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj)  //判断当前集合与指定集合是否相同
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry", 20));
        System.out.println(coll.equals(coll1));

    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --> 数组 ：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //数组 -->集合 调用Arrays类的静态方法asList()
        List list = Arrays.asList(new String[]{"AA", "BB", "CC", "KK"});
        System.out.println(list);

        List arr1 = Arrays.asList(new Integer(124), new Integer(345));
        System.out.println(arr1);

    }

}
