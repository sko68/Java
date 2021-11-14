package com.sk.java1;

import org.junit.Test;

import java.util.List;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/12 18:47
 * @Version 1.0
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);

    }
}
