package com.sk.java;

import org.junit.Test;

/**
 * @Description: TODO
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/6 11:06
 * @Version 1.0
 */
public class StringMethodTest {
    /**
    int length()：返回字符串的长度： return value.length
    char charAt(int index)： 返回某索引处的字符return value[index]
    boolean isEmpty()：判断是否是空字符串：return value.length == 0
    String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
    String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
    String trim()：返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj)：比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
    int compareTo(String anotherString)：比较两个字符串的大小
    String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
    String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

     */
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s2);
        String s3 = s1.toUpperCase();
        System.out.println(s3);

        String s4 = "  He llo World  ";
        String trim = s4.trim();
        System.out.println("---"+ s4 + "---");
        System.out.println("---"+ trim + "---");



    }

    @Test
    public void test2(){
        String s1 = "HellWorld";
        String s2 = "hellworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = "abe";
        System.out.println(s5.compareTo(s6));  //涉及到字符串排序


        String s7 = "昆明理工大学";
        String s8 = s7.substring(3);
        System.out.println(s8);
        String s9 = s7.substring(2, 4);
        System.out.println(s9);

    }

    /**
     boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始

     boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
     boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
     int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

     注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test3(){
        String s1 = "HelloWorld";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = s1.startsWith("He");
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll",2);
        System.out.println(b3);

        String s2 = "Wo";
        System.out.println(s1.contains(s2));

        System.out.println(s1.indexOf("lol"));
        System.out.println(s1.indexOf("lo",5));

        String s3 = "HellorWorld";
        System.out.println(s3.lastIndexOf("or"));

        System.out.println(s3.lastIndexOf("or",6));




    }

    /**
     替换
     String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     匹配:
     boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     切片：
     String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

     */
    @Test
    public void test4(){
        String str1 = "昆明理工大学";
        String str2 = str1.replace("理工", "科技");
        System.out.println(str2);

        String str3 = str1.replace("大", "小");
        System.out.println(str3);

        System.out.println("*************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        System.out.println("*************************");
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        System.out.println("*************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }




    }

}

