package com.sk.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/10 19:59
 * @Version 1.0
 */
public class TreeSetTest {

    /**
     * 1.向TreeSet中添加的数据，要求是相同类的对象
     * 2.两种排序方式：自然排序(实现comparable接口) 和定制排序(comparate)
     *
     *
     * 3.自然排序中，比较两个对象是否相同的标准为compareTo()返回0，不再时equals();
     * 4.定制排序中，比较两个对象是否相等的标准为compare()返回0，不再时equals();
     *
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //不能添加不同类的对象

//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom", 12));

        //举例一
//        set.add(56);
//        set.add(58);
//        set.add(12);
//        set.add(66);
//        set.add(99);

        //举例二
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 22));
        set.add(new User("Mike", 18));
        set.add(new User("Jack", 56));
        set.add(new User("Jim", 45));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到达排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }


            }
        };


        TreeSet set = new TreeSet(com);
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 22));
        set.add(new User("Mike", 18));
        set.add(new User("Jack", 56));
        set.add(new User("Jim", 45));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
