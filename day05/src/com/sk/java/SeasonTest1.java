package com.sk.java;

/**
 * @Description: 使用enum来定义枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum类
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/9 15:18
 * @Version 1.0
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        //toString()
        System.out.println(spring.toString());
        System.out.println(Season1.class.getSuperclass());
        System.out.println("************************");
        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < Season1.values().length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName) //返回枚举类中对象名是objName的对象，如果找不到，报异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

        winter.show();


    }
}

interface Info{
    void show();
}

//自定义枚举类
enum Season1 implements Info {


    //提供当前枚举类的多个对象,多个对象之间用",",结尾用";"
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天来了");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋雨");
        }
    },
    WINTER("冬天", "冬雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天不回来");
        }
    },
    ;

    //1声明Season对象的属性 private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }

    //4、获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //5.提供toString方法
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
