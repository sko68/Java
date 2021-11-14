package com.sk.java;

/**
 * 多线程得创建：
 * 方式一：继承于Thread类
 *      1.创建一个继承于Threa类得=的子类
 *      2.重写Thread类的run()方法  -->将此线程执行的操作声明在run()中
 *      3.创建Thread类的子类的对象
 *      4.通过此对象调用start();
 *
 * eg.遍历100以内的偶数
 */
//1.创建一个继承于Thread类得=的子类
class MyThread extends Thread{
    //2.重写Thread类的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) {

        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start();①启用当前线程；②调用当前线程的run()；
        t1.start();


        //再启动一个线程遍历100以内的偶数,需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
