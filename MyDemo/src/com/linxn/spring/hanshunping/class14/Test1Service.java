package com.linxn.spring.hanshunping.class14;

/**
 * Created by Linxn on 2017/3/12.
 */
public class Test1Service implements TestServiceInter {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    @Override
    public void sayHello() {
        System.out.println("Hi " + name);
    }
}
