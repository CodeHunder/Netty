package com.ai.pojo;

import com.sun.org.apache.bcel.internal.generic.IFNE;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZINING
 * @Date 2017/12/2 17:48
 */
public class Person implements Cloneable {

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

    private String name;
    private int age;


    public String toString() {
        return "name:" + this.name + " age:" + this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }


    public static void main(String[] args) throws Exception {
        Person p = new Person();
        List<Person> personList = new ArrayList<Person>();
        p.age = 123;
        p.name = "n123";
        Person p1 = p;
        Person p2 = (Person) p.clone();
        p1.age = 12;
        p1.name = "n12";
        p2.name = "n1";
        p2.age = 1;
        System.out.println(p.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

}
