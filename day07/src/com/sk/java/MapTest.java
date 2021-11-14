package com.sk.java;

import org.junit.Test;

import java.util.*;

/**
 * @Description: TODO
 * 一、Map的实现类的结构
 *  |----Map:双列数据，存储key-value对数据
 *          |----HashMap：作为Map主要实现类，线程不安全，效率高；存储null的key和value
 *              |----LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                      原因:在原有HashMap底层结构基础上，添加一对指针，指向前一个和后一个元素
 *                      对于频繁的遍历操作，此类执行效率高于HashMap
 *          |----TreeMap：保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序或定制排序
 *                  底层使用红黑树
 *          |----Hashtable：作为古老实现类，线程安全，效率低；不能存储null的key和value
 *              |----Properties :常用来处理配置文件，key和value都是String类型
 *
 *
 *
 * HashMap的底层：数组+链表  （jdk7及之前)
 *                数组 + 链表 + 红黑树 （jdk8）
 * 面试题
 * 1.HashMap的底层实现原理？
 * 2.HashMap和Hashtable的异同？
 * 3.CurrentHashMap 和 Hashtable的异同？
 *
 * 二、Map结构的理解
 * Map中的key：无序的、不可重复的，使用set存储所有的key -->key 所在的类要重写equals和HashCode(),以HashMap为例
 * Map中的value:无序的、可重复的，使用Collection存储所有的value --> value所在的类要重写equals()
 * 一个键值对:key-value构成了一个Entry对象
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 * 三、HashMap底层实现原理，以jdk7为例说明
 * HashMap map = new HashMap();
 * 在实例化以后，底层创建了长度为16的一维数组Entry[]table.
 * ...可能已经执行过多次put...
 * map.put(key1,value1):
 * 首先调用key所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后得到在Entry数组中存放的位置
 * 如果此位置上的数据为空，此时的key1-value1添加成功。----情况1
 * 如果此位置上数据不为空，（意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据的哈希值：
 *      如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。 --情况2
 *      如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)比较
 *          如果equals返回false：此时key1-value1添加成功  -->情况3
 *          如果equals返回true：此时使用value1替换value2
 *
 * 补充：关于情况二和情况三 此时key1-value1和原来的数据以链表形式存储
 *  在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 * jdk8相较与jdk7在底层实现方明的不同：
 * 1.new HashMap；底层没有创建一个长度为16的数组
 * 2.jdk8底层的数组是Node[],而非entry[]
 * 3.首次调用put()方法时，底层创建长度为16的数组
 * 4.jdk 7 底层结构只有：数组 + 链表，jdk8底层结构：数组 + 链表 + 红黑数
 *      4.1形成链表时，七上八下（jdk7：新的元素指向旧的元素，jdk8：旧的元素指向新的元素)
 *      4.2当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8,且当前数组的长度大于64 时，此时索引位置上的数据改为用红黑数存储

 *  DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *  DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *  threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 *  TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 *  MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 * 四、LinkedHashMap的底层实现原理（了解）
 * 源码中：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *              Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *              Entry(int hash, K key, V value, Node<K,V> next) {
 *                 super(hash, key, value, next);
 *              }
 *          }
 *
 * 五、Map中定义的方法：
 * 添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *  总结：常用方法：
 *  添加：put(Object key,Object value)
 *  删除：remove(Object key)
 *  修改：put(object key,Object value)
 *  查询：get(Object key)
 *  长度：size()
 *  遍历：keySet(),valueSet(),entrySet()
 *
 * @Author SK
 * @Email sk16168@163.com
 * @Date 2021/11/11 11:00
 * @Version 1.0
 */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null,123);

    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123, "DD");
        map.put(12, "aa");
        map.put(3, "MM");
        map.put(18, "LL");
        System.out.println(map);

    }
    @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("45", 63);
        map.put("BB", 35);
        //修改
        map.put("BB", 45);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("FF", 66);
        map1.put("HH", 90);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("AAA");
        System.out.println(map);

        //clear()
        map.clear(); //map = null
        System.out.println(map);
        System.out.println(map.size());
    }
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("45", 63);
        map.put("BB", 35);
        //Object get（Object key)
        System.out.println(map.get("45"));

        //boolean containsKey(Object key)
        boolean b1 = map.containsKey("BB");
        System.out.println(b1);

        //boolean containsValue(Object value)
        boolean value = map.containsValue(35);
        System.out.println(value);

        //int size()：返回map中key-value对的个数
        System.out.println(map.size());

        //boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());

        //boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        boolean equals = map.equals("45");
        System.out.println(equals);


    }

    @Test
    public void test5(){

        Map map = new HashMap();
        map.put("AA", 123);
        map.put("45", 63);
        map.put("BB", 35);

        //遍历所有的key集：Set keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历所有的value的集：Collection values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);

        }

        //Set entrySet()：返回所有key-value对构成的Set集合
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        //



    }
}
