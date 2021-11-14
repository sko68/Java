package com.sk.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 *
 * 解决线程安全问题的方式三:Lock锁 --JDK5.0新增
 * 1.面试题:synchronized与Lock的异同?
 * 相同:二者都可以解决线程安全问题、
 * 不同:synchronized机制在执行完相应同步代码后，自动释放同步监视器
 * Lock需要手动启动同步（lock()),同时结束也需要手动实现（unlock())
 *
 * 2.优先使用顺序
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体外)
 *
 * 面试题 ：如何解决线程安全问题？有几种方式
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/5 16:18
 * @Version 1.0
 */

class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run(){
        while(true) {
            if (ticket > 0) {
                //2.调用锁定方法lock()

                try {
                    lock.lock();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                ticket--;
            }
            else {
                break;
            }
            lock.unlock();

        }
    }
}
public class LockTest {
        public static void main(String[] args) {
            Window w = new Window();

            Thread t1 = new Thread(w);
            Thread t2 = new Thread(w);
            Thread t3 = new Thread(w);

            t1.setName("窗口1");
            t2.setName("窗口2");
            t3.setName("窗口3");

            t1.start();
            t2.start();
            t3.start();
        }


}
