package com.sk.java1;

/**
 * @Description: TODO
 * 1.理解Annotation
 * ① jdk 5.0 新增的功能
 *
 * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *
 * ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 * 中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 *
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 *
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解，参照@SupperWarings的定义
 * ①注解声明为@interface
 * ②内部定义成员，通常使用value表示
 * ③可以指定成员默认值，使用default
 * ④如果自定义注解没有成员，表明是一个标识作用
 *
 * 如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 * 自定义注解通常会指定两个元注解，一个是声明周期，一个是
 *
 * 4.jdk 提供的四种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention ：指定所修饰的Annotation的生命周期SOURCE\CLASS\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才可以通过反射获取
 * Target ：用于指定被修饰的Anotation，能用于哪些程序元素
 * Documented ：标识所修饰的注解被javadoc解析时被保留下来
 * Inherited ：被它修饰的Annotation将具有继承性
 *
 * 5.通过反射来获取注解信息
 *
 * 6.jdk8 中注解的新特性：可重复定义注解
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/9 16:13
 * @Version 1.0
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p1 = new Student();
        p1.eat();
    }
}

@MyAnnotation (value = "hi")
//jdk 8 之前的写法
//@MyAnnotations({@MyAnnotation("hello"),@MyAnnotation("abc")})
class Person{
    private String name;
    private int age;

    public Person() {
    }
    public void walk(){
        System.out.println("人走路");

    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{

}
class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
}
