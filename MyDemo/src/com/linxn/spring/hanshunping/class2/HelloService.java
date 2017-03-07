package com.linxn.spring.hanshunping.class2;

/**
 * Created by Linxn on 2017/3/7.
 */
public class HelloService {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void sayHello(){
        System.out.println("Hello "+name+"!");
    }
}
