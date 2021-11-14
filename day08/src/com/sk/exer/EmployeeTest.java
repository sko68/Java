package com.sk.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description: TODO
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * <p>
 * 1). 使Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/12 9:44
 * @Version 1.0
 */
public class EmployeeTest {


    //问题一：使用自然排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("liudehua", 56, new MyDate(1965, 3, 5));
        Employee e2 = new Employee("zhanagxueyou", 49, new MyDate(1970, 6, 7));
        Employee e3 = new Employee("gutianle", 44, new MyDate(1976, 7, 36));
        Employee e4 = new Employee("liangchaowei", 37, new MyDate(1983, 8, 9));
        Employee e5 = new Employee("guofucheng", 55, new MyDate(1968, 11, 23));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);

        }

    }

    //问题二：按照生日日期排序
    @Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    //方式一：
                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if (minusMonth != 0) {
//                        return minusMonth;
//                    }
//
//                    //比较日
//                    return b1.getDay() - b2.getDay();

                    //方式二：
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        Employee e2 = new Employee("zhanagxueyou", 49, new MyDate(1970, 6, 7));
        Employee e1 = new Employee("liudehua", 56, new MyDate(1965, 3, 5));
        Employee e4 = new Employee("liangchaowei", 37, new MyDate(1983, 8, 9));
        Employee e5 = new Employee("guofucheng", 55, new MyDate(1968, 11, 23));
        Employee e3 = new Employee("gutianle", 44, new MyDate(1976, 7, 36));

        set.add(e3);
        set.add(e2);
        set.add(e1);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
