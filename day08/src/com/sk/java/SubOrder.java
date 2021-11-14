package com.sk.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/12 12:55
 * @Version 1.0
 */
public class SubOrder extends Order<Integer>{  //SubOrder不是泛型类
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
