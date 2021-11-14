package com.sk.java;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 19:34
 * @Version 1.0
 * <p>
 * 问题：在买票的过程中出现了重票、错票 -->线程安全问题
 * 出现的原因:当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来也操作车票
 * 如何解决:当一个线程A在操作ticket的时候，其他线程不能参与进来，直到线程A操作完ticket时其他线程才可以操作做ticket,这种情况即使
 * 线程A出现了阻塞，也不能改变
 * <p>
 * 在java中通过同步机制来解决
 * 方式一:同步代码块
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 说明:操作共享数据的代码即为需要被同步的代码快
 * 共享数据:多个线程共同操作的变量
 * 同步监视器:俗称"锁",任何一个类的对象都可以充当锁
 * 要求：多个线程必须公用一个锁
 * 补充:在实现runnable接口创建多线程中，我们可以考虑使用this来充当锁
 * <p>
 * 方式二：同步方法
 * 如果操作共享数据的代码完整地声明在一个方法中，不妨将此方法设为同步方法
 * <p>
 * 5.同步的方式，解决了线程安全问题  --好处
 * 操作同步代码时，只能有一个线程操作，其他线程等待，相当于单线程，但效率低
 */
class Window1 implements Runnable {
    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//                synchronized(obj) {
            synchronized (this) {  //此时的this:唯一的window1的对象
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
