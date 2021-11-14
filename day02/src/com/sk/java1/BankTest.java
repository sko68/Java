package com.sk.java1;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/5 10:27
 * @Version 1.0
 */
public class BankTest {
}

class Bank{
    private Bank(){
    }
    private static Bank instance = null;
    public static Bank getInstance(){
        //方式一:效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二：效率稍高
        if(instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }

            }
        }
        return instance;
    }
}