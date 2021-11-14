package com.sk.java;

/**
 * @Description: 创建三个窗口买票，总票数为100,使用继承Thread的方式
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 18:49
 * @Version 1.0
 * <p>
 * 存在线程安全问题
 * <p>
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * <p>
 * 在继承Thread类创建多线程的1方式中慎用this充当同步监视器，可以考虑使用当前类来充当同步监视器
 */
class Window2 extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
