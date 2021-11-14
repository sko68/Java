package com.sk.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/11 17:01
 * @Version 1.0
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        //Properties用来处理配置文件，key和value都是String类型
        Properties pro = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        pro.load(fis); //加载对应流文件

        String name = pro.getProperty("name");
        String age = pro.getProperty("age");

        System.out.println("name = " + name + " age= " + age);

    }
}
