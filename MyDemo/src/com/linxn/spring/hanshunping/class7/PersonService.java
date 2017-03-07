package com.linxn.spring.hanshunping.class7;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Linxn on 2017/3/7.
 *
 * 展示了整个bean的生命周期  不过不是全部都是必要的
 */
public class PersonService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void sayHello(){
        System.out.println("Hello " + name + "!");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("Bean name is "+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean factory is " + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context is " + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用了 afterPropertiesSet 方法");
    }

    public void myInit(){
        System.out.println("调用了 myInit 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用了 destory 方法");
    }
}
