package com.sk.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Description: TODO
 * 集合元素的遍历操作，使用Iterator接口
 * 内部方法：hasNext()和next()
 * 集合每次调用iterator()方法都会得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 * 3.内部定义了remove(),可以在遍历时，删除除集合中的元素，此方法不同于集合直接调用remove()
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/10 11:22
 * @Version 1.0
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        Iterator iterator = coll.iterator();
        //方式二
//        System.out.println(iterator.next());
        //方式二 : 不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        //方式三：
        //hasNext() :判断是否还有下一个元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //测试Iterator中的remove()方法使用
    //如果还未调用next()或在上一次调用next()方法之后调用了remove方法
    //再调用remove都会报IllegalStateException
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //删除集合中指定对象
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }
        //遍历集合
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }



    }
}
