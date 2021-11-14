package com.sk.exer;


import org.junit.Test;

/**
 * @Description: 将一个字符串进行反转，将字符串指定部分进行反转，比如"abcdefg"反转为"abfedcg"
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 17:26
 * @Version 1.0
 */
public class StringDemo {
    //方式一：
    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
        char[] arr = str.toCharArray();
        for (int x = startIndex,y = endIndex; x < y; x++,y--){
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return new String(arr);
        }
        return null;

    }

    //方式二：使用String的拼接·操作
    public String reverse1(String str,int startIndex,int endIndex){
        if(str != null){
            String revsrseStr = str.substring(0, startIndex);
            for (int i = endIndex; i >= startIndex; i--) {
                revsrseStr += str.charAt(i);

            }
            revsrseStr += str.substring(endIndex + 1);
            return revsrseStr;

        }
        return null;


    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse = reverse1(str, 2, 5);
        System.out.println(reverse);
    }
}
