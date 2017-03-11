package com.linxn.spring.hanshunping.class11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/9.
 *
 * cat采用了构造函数注入属性值
 * master对象实现了自动装配bean
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class11/beans.xml");
        Master master = (Master) ac.getBean("master");
        System.out.println(master.getName()+"养了"+master.getCat().getName()+"(●'◡'●)..");
    }
}
