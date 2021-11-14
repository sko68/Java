package com.sk.java;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 22:21
 * @Version 1.0
 *
 *使用同步方法解决实现Runnable接口的线程安全
 * 同步方法仍然涉及到同步监视器，知识不需要显示的声明
 * 非静态的同步方法，同步监视器是this
 * 静态的同步方法监视器是当前类本身
 */
class Window3 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
            else {
                break;
            }
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}