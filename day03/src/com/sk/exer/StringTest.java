package com.sk.exer;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 10:45
 * @Version 1.0
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    public void change(String str,char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);

        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
}
