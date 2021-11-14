package com.sk.java;

/**
 * 测试Thread类中的常用方法
 *1、start()  :启用当前线程，调用当前线程的run()
 * 2、run()   :通常需要重写Thread类中的run()方法，将创建的要执行的操作声明再此方法中
 * 3、currentThread()  :静态方法，返回执行当前代码的线程
 * 4、getName()   :获取当前线程的名字
 * 5、setName()   :设置当前线程的名字
 * 6、yield()     :释放当前CPU的执行权
 * 7、join()      :在线程A调用线程B的join(),线程A进入阻塞状态，直到线程B执行完，线程A才结束阻塞状态
 * 8、stop()      :已过时，强制结束当前线程
 * 9、sleep(long millitime)     :让当前线程睡眠指定的millitime毫秒，在指定的毫秒内当前线程是阻塞的
 * 10、isAlive    :判断当前线程是存活
 *
 * 线程的优先级
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5   --->默认优先级
 *
 * 如何获取和设置当前线程的优先级
 * getPriority()  获取当前线程的优先级
 * setPriority(int p)  设置当前线程的优先级
 * 注意:高优先级的线程要抢占低优先级的线程cpu执行权，只是从概率上来讲，高优先级的线程高概率情况被优先执行，并不意味着只有高优先级执行完了才执行低优先级
 *
 *
 *
 *
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
            if(i % 10 ==0){
                yield();
            }

        }
    }
    public HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread_1");

        //设置分线程的优先级
        h1.setPriority(10);
        h1.start();


        //主线程
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setName("主线程:");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);
            }
//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }
}



