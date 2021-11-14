package com.sk.java1;

/**
 * @Description: 演示线程的死锁问题
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不释放，都在等待对方放弃自己需要的同步资源，就此形成了线程的死锁
 * 2.说明
 * 1)出现死锁后不会出现异常，不会出现提示，只是所有线程处于阻塞状态，无法继续
 * 2)我们使用同步是，要避免出现死锁
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/5 10:45
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(){
            @Override
            public void run(){
                synchronized(s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();


        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized (s2){

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }


                }
            }

        }).start();
    }
}
