package com.linxn.spring.hanshunping.class14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/12.
 *
 * aop编程
 * 1 创建接口
 * 2 被代理对象（类）实现接口
 * 3 实现通知类
 * 4 配置
 *   4.1配置通知（本Demo为前置通知）
 *   4.2配置被代理对象
 *   4.3配置代理对象 （spring提供 ProxyFactoryBean）
 *     4.3.1配置代理接口集 name=proxyInterfaces（包括接口的完整路径）
 *     4.3.2配置通知名集 name=interceptorNames（前置通知）
 *     4.3.3配置被代理对象 name=target
 * 5 取对象的时候取代理对象
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class14/beans.xml");
        TestServiceInter obj = (TestServiceInter) ac.getBean("proxyFactoryBean");
        obj.sayHello();
    }
}
