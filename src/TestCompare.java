import java.util.*;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) { // compareTo方法什么时候生效，当调用TreeMap的put方法时，会调用compareTo方法，
        // 如果返回值为0，就会认为是同一个对象，就会覆盖,arrayList的sort方法也会调用compareTo方法
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
public class TestCompare {
    public static void main(String[] args) {
        TreeMap<Person, String> pdata = new TreeMap<Person, String>();
        // 为什么用HashMap存储无法按照年龄排序，而用TreeMap就可以按照年龄排序，因为TreeMap是有序的
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());
        }
        HashMap<Person, String> pdata1 = new HashMap<Person, String>();
        pdata1.put(new Person("张三", 30), "zhangsan");

        System.out.println("----------------------------------------------------");
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 30));
        list.add(new Person("李四", 20));
        list.add(new Person("王五", 10));
        list.add(new Person("小红", 5));
        Collections.sort(list);  // 通过Collections.sort方法，可以对list集合进行排序
        for (Person person : list) {
            System.out.println(person.getAge() + "-" + person.getName());
        }
    }
}
