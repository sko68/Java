package com.sk.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: TODO
 * 一、网络编程中的两个主要问题
 * 1.如何准确定位网络上一台或多台主机;定位主机上特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程的两个要素
 * IP和端口号
 * 提供网络通信协议TCP/IP模型（应用层、传输层、网络层、数据链路层、物理层)
 *
 * 三、通信要素一：IP和端口号
 * 1.IP：唯一标识Internet上的计算机
 * 2.在Java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和 IPv6 ; 万维网 和 局域网
 * 4.域名：www.baidu.com   www.mi.com  www.sina.com  www.jd.com  ww.vip.com
 * 5.本地回路地址：127.0.0.1 对应着：localhost
 *
 * 6.如何实例化InetAddress：两个方法：getByName（String host)、getLocalHost()
 * 两个常用方法：getHostName()/getHostAddress()
 *
 * 7.端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：被规定为一个16位的整数0~65535
 *
 * 8.端口号与IP地址的组合得出一个网络套接字Socket
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/14 19:29
 * @Version 1.0
 */
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress inet1 = InetAddress.getByName("10.36.2.140");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println("inet4: " + inet4);

            //getHostAddress()
            System.out.println(inet2.getHostAddress());
            //getHostName()
            System.out.println(inet1.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
