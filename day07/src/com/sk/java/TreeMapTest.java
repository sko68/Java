package com.sk.java;

import org.junit.Test;

import java.util.*;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/11 16:37
 * @Version 1.0
 */
public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序，定制排序

    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User user1 = new User("Tom", 25);
        User user2 = new User("Jerry", 15);
        User user3 = new User("Jack", 20);
        User user4 = new User("Rose", 26);

        map.put(user1, 99);
        map.put(user2, 88);
        map.put(user3, 78);
        map.put(user4, 90);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        User user1 = new User("Tom", 25);
        User user2 = new User("Jerry", 15);
        User user3 = new User("Jack", 20);
        User user4 = new User("Rose", 26);

        map.put(user1, 99);
        map.put(user2, 88);
        map.put(user3, 78);
        map.put(user4, 90);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }
}
