package com.sk.java;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 19:34
 * @Version 1.0
 */
class Window1 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }
    private synchronized void show(){  //同步监视器 this
        if(ticket > 0)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
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
