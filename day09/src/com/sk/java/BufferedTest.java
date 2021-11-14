package com.sk.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description: TODO
 * 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用：提高流的读取写入速度（内部提供一个缓冲区
 * 处理流：就是套接在已有流的基础上
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/13 20:39
 * @Version 1.0
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("E:\\picture\\5fdc0e8179aa68331b26e2c6a61b789d.jpg");
            File destFile = new File("E:\\picture\\bufferedStream.jpg");
            //2.造流的对象
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.赋复制的细节，读取和写入
            byte[] buff = new byte[10];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求先关闭外层的流，在关内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //关闭外层流的同时。内层流也会自定关闭，关于内层流的关闭可以省略
//        fos.close();
//        fis.close();
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流的对象
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.赋复制的细节，读取和写入
            byte[] buff = new byte[8];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求先关闭外层的流，在关内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "E:\\picture\\5fdc0e8179aa68331b26e2c6a61b789d.jpg";
        String destPath = "E:\\picture\\p2.jpg";

        copyFileWithBuffered(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618
    }

    //使用BufferedReader和BufferedWriter实现文本文件的复制
    @Test
    public void testBufferedReaderWriter() {

        BufferedReader bis = null;
        BufferedWriter bos = null;
        try {
            //1.造文件
            FileReader srcFile = new FileReader("E:\\picture\\dbcp.txt");
            FileWriter destFile = new FileWriter("E:\\picture\\dbcp1.txt");
            //2.造流的对象
            //2.1造节点流
            BufferedReader fis = new BufferedReader(srcFile);
            BufferedWriter fos = new BufferedWriter(destFile);

            //2.2造缓冲流
            bis = new BufferedReader(fis);
            bos = new BufferedWriter(fos);

            //3.赋复制的细节，读取和写入
            char[] buff = new char[8];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求先关闭外层的流，在关内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
