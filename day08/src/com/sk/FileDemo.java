package com.sk;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/13 8:36
 * @Version 1.0
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file1 = new File("E:\\code-java\\JavaSenior");
        //创建一个同目录下的另一个文件，文件名为：haha.txt
        File destFile = new File(file1.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }


    }
}
