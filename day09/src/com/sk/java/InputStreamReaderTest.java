package com.sk.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description: TODO
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流的转换
 *
 * 3.解码：字节、字符数组 -->字符数组、字符串
 *   编码：字符数组、字符串 -->字节、字节数组
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/14 12:27
 * @Version 1.0
 */
public class InputStreamReaderTest {
    @Test
    public void test1() {

        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集，具体使用那个字符集，取决与文件保存是使用的字符集
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf) ) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //综合使用InputStreamReader和OutputStreamWriter
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //造文件、造流
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos);

            //读写过程
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
