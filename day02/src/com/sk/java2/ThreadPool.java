package com.sk.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 *
 * 创建线程的方式四 ：线程池
 * 好处:
 * 1.提高响应速度
 * 2.降低资源消耗(重复利用线程池中的线程，不需要每次都创建)
 * 3.便于线程管理
 *
 * 面试题：创建线程有几种方式 ？  4种
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/5 21:36
 * @Version 1.0
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }

        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread()); //适合使用Runna
        //service.submit(); //适合使用于Callab
        service.shutdown();  //关闭连接池
    }
}
