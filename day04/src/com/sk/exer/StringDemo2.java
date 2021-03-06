package com.sk.exer;

import org.junit.Test;

/**
 * @Description: TODO
 *获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * 前提：两个字符串中只有一个最大相同子串
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 21:06
 * @Version 1.0
 */
public class StringDemo2 {
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }

            }

        }

        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);

    }

}
