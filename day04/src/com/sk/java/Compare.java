package com.sk.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: java中的对象，正常情况只能进行比较：== 或!=，不能进行 > 或者 < 的
 * 但是，在开发中，我们需要对多个对象进行排序，即比较对象的大小
 * 如何实现？使用两个接口中的任何一个Comparable或Comparator
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/8 15:52
 * @Version 1.0
 *
 * Comparable接口的使用
 */
public class Compare {
    /**
     * Comparable接口的使用举例:自然排序
     1.像String，包装类实现了Comparable接口，重写了compareTo方法，给出了比较两个对象大小的方法
     像String、包装类重写compareTo方法以后，进行从小到大排列
     3.重写compareTo的规则
     如果当前对象this大于形参对象obj，则返回正整数，
     如果当前对象this小于形参对象obj，则返回负整数，
     如果当前对象this等于形参对象obj，则返回零。
     4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，
     重写compareTo(obj)方法。
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA", "CC", "JJ", "GG", "MM", "DD", "KK"};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 22);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 43);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparetor接口的使用:定制排序
     * 1.背景:
     * 当元素的类型没有实现Java.lang.Comparable接口而又不方便改代码
     * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作
     * 那么可以考虑使用Comparable的对象来排序
     * 2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小
     * 如果方法返回正整数，则表示o1大于o2
     * 如果返回0表示相等
     * 返回负整数，表示o1小于o2
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator<String>() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator<Goods>() {
            //指明商品比较大小的方式，按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;
                    if (goods1.getName().equals(goods2.getName())) {
                        return Double.compare(goods1.getPrice(), goods2.getPrice());
                    } else {
                        return goods1.getName().compareTo(goods2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }


}
