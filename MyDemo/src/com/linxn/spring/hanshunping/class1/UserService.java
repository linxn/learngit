package com.linxn.spring.hanshunping.class1;

/**
 * Created by Linxn on 2017/3/7.
 */
public class UserService {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void sayHello(){
        System.out.println("hello " + name + "!");
    }
}
