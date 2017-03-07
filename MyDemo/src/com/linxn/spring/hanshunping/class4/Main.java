package com.linxn.spring.hanshunping.class4;

import com.linxn.spring.hanshunping.class1.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/7.
 *
 * 使用接口来实现  转换接口时只需要修改xml文件
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class4/beans.xml");
        //可以用ChangeLetter接口来声明
        ChangeLetter obj = (ChangeLetter) ac.getBean("changeLetter");
        System.out.println(obj.Change());
    }
}
