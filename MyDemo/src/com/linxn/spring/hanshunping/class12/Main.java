package com.linxn.spring.hanshunping.class12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/9.
 *
 * 分散配置
 * 使用配置文件db.properties来配置bean注入的值
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class12/beans.xml");
        DBUtil obj = (DBUtil) ac.getBean("dbUtil");
        System.out.println("name:"+obj.getName()+"\ndriver:"+obj.getDriver()+"\nurl:"+ obj.getUrl()+"\npwd:"+obj.getPwd());
    }
}
