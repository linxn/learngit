package com.linxn.spring.hanshunping.class7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/7.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class7/beans.xml");
        PersonService obj = (PersonService) ac.getBean("personService");
        obj.sayHello();
    }
}
