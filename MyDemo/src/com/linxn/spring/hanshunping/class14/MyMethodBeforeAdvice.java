package com.linxn.spring.hanshunping.class14;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Linxn on 2017/3/12.
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    /*
     *method:被调用方法名字
     *args:给method传递的参数
     *target:目标对象
     */

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("记录日志..."+method.getName()+"接口");
    }
}
