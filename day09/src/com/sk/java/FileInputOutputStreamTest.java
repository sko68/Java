package com.sk.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description: TODO
 * 测试FileInputStream和FileOutputStream的使用
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 * //使用字节流FileInputStream处理文本文件，可能出现乱码。
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/13 16:39
 * @Version 1.0
 */
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputOutputStream() {

        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("E:\\picture\\5fdc0e8179aa68331b26e2c6a61b789d.jpg");
            File destFile = new File("E:\\picture\\dest.tif");

            //创建输入输出流的对象
            fi = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);

            //3.文件的读入和写出操作
            byte[] cbuf = new byte[5];
            int len;  //记录每次读入到cbuf数组中的字符的个数
            while ((len = fi.read(cbuf)) != -1) {
                fo.write(cbuf, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //创建输入输出流的对象
            fi = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);

            //3.文件的读入和写出操作
            byte[] cbuf = new byte[8];
            int len;  //记录每次读入到cbuf数组中的字符的个数
            while ((len = fi.read(cbuf)) != -1) {
                fo.write(cbuf, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {

        long start = System.currentTimeMillis();
        String srcPath = "E:\\picture\\5fdc0e8179aa68331b26e2c6a61b789d.jpg";
        String destPath = "E:\\picture\\p2.jpg";

        copyFile(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618
    }


}
