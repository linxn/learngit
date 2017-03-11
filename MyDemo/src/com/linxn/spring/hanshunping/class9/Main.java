package com.linxn.spring.hanshunping.class9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Linxn on 2017/3/8.
 *
 * 向集合中注入值  数组 List Set Map
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/linxn/spring/hanshunping/class9/beans.xml");
        Department department = (Department) ac.getBean("department");
        //print 数组
//        for (String emName:department.getEmployee()) {
//            System.out.println(emName);
//        }
        //print List
//        for (Employee employee:department.getEmployees()) {
//            System.out.println(employee.getName());
//        }
        //print Set
//        for (Employee employee:department.getEmployees()
//             ) {
//            System.out.println(employee.getName());
//        }
        //print Map
        //1.Entry取值
//        for (Map.Entry<Integer,Employee> entry:department.getEmployeeMap().entrySet()
//             ) {
//            System.out.println(entry.getKey()+"   "+entry.getValue().getName());
//        }
        //2.迭代取值
        Map<Integer, Employee> employeeMap = department.getEmployeeMap();
        Iterator it = employeeMap.keySet().iterator();
        while (it.hasNext()){
            Integer key = (Integer) it.next();
            Employee emp = employeeMap.get(key);
            System.out.println(key+"    "+emp.getName());
        }
    }

}
