package com.sk.exer;

import org.junit.Test;

/**
 * @Description: 获取一个字符串在另一个字符串中出现的次数
 * 比如:获取"ab" 在 "abkkcadkabkebfkabkskab"中出现的次数
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 19:26
 * @Version 1.0
 */
public class StringDemo1 {
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
            //方式一
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
//            return count;
         //方式二：对方式一的改进

         while ((index = mainStr.indexOf(subStr,index)) != -1){
             count++;
             index += subLength;

         }
            return count;

        }
        return 0;
    }
    @Test
    public void test(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subString = "ab";
        int count = getCount(mainStr, subString);
        System.out.println(count);
    }
}

