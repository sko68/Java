package com.sk.java;

/**
 * @Description: 创建三个窗口买票，总票数为100,使用继承Thread的方式
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/4 18:49
 * @Version 1.0
 *
 *存在线程安全问题
 */
class Window extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName() + "票号为：" + ticket);
                ticket--;
            }
            else {
                break;
            }
        }

    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
