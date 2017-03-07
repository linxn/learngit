package com.linxn.spring.hanshunping.class2.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/7.
 */
 final public class ApplicationContextUtil {
    private static ApplicationContext ac = null;
    private ApplicationContextUtil(){}

    static{
       ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class2/beans.xml");

    }

    public static ApplicationContext getAc() {
        return ac;
    }
}
