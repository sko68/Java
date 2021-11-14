package com.sk.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description: TODO
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取和读取基本数据类型数据或对象的处理流。他的强大之处就是可以把Java中的对象写入到数据源中，
 * 也能把对象从数据源中还原回来
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求。Person.java
 *
 * 4.序列化的机制
 * 对象序列化机制允许吧内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流永久地保存在磁盘上，
 * 或通过网络这种二进制流传输到另一个网络节点，当其他程序获取了这种二进制流，就可以恢复成原来的java对象
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/14 13:27
 * @Version 1.0
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化的过程：将内存中的Java对象保存在磁盘中或通过网络传输出去
    使用ObjectOutputStream

     */
    @Test
    public void testObjectOutputStream() throws IOException {
        //1.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        //2.
        oos.writeObject(new String("我是一一只小鸭子"));
        oos.flush();//刷新操作
        oos.writeObject(new Person("李华",23));
        oos.flush();

        oos.writeObject(new Person("张三",19));

    }
}
