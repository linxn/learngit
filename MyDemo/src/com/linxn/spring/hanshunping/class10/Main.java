package com.linxn.spring.hanshunping.class10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Linxn on 2017/3/8.
 *
 * bean的继承 设置parent属性 可以覆盖父对象的继承
 * proerty属性值的设置 【？不能用ref？】
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class10/beans.xml");
        Degree degree = (Degree) ac.getBean("degree");
        System.out.println(degree.getName()+" "+degree.getAge()+" "+degree.getDegree());
    }
}
