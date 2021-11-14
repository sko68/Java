package com.sk.java;

import java.io.Serializable;

/**
 * @Description: TODO
 * Person需要满足如下条件，方可实例化
 * 1.需要实现接口：Serializable接口之外，还必须保证其内部所有属性
 * 也必须是可序列化的。(默认情况下，基本数据类型可序列化)
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/14 18:43
 * @Version 1.0
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 3876545678L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    class Account implements Serializable{
        public static final long serialVersionUID = 98767894567L;
        private double balance;

        public Account(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "balance=" + balance +
                    '}';
        }
    }
}
