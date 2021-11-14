package com.sk.java;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 19:12
 * @Version 1.0
 *
 * 创建多线程的方式二:实现runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 * 比较创建线程的两种方式:
 * 开发中，优先选择实现runnable方式
 * 原因:1.实现的方式没有类的单继承的局限性
 * 2。实现的方式跟适合用来处理多个线程有共享数据的情况
 *
 * 相同点:两种方式都重写了run()方法,将线程执行的逻辑写道run()方法中
 * 要想启动线程，都是调用Thread类中的start();
 *
 */

//    1.创建一个实现了Runnable接口的类
class MThread implements Runnable{
//    2.实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +":" + i);
            }
        }

    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
//        3.创建实现类的对象
        MThread mThread = new MThread();
//        4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
//        5.通过Thread类的对象调用start()
        t1.start();

        //再启动一个线程
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
