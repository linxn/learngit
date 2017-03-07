package com.linxn.spring.hanshunping.class1;

import com.linxn.spring.hanshunping.class1.UserService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/7.
 *
 * 简单依赖注入Demo
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class1/beans.xml");
        UserService obj = (UserService) ac.getBean("userService");
        obj.sayHello();
    }


}
