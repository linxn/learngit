package com.linxn.spring.hanshunping.class2;

/**
 * Created by Linxn on 2017/3/7.
 */
public class ByeService {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public com.linxn.spring.hanshunping.class2.HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(com.linxn.spring.hanshunping.class2.HelloService helloService) {
        this.helloService = helloService;
    }

    private com.linxn.spring.hanshunping.class2.HelloService helloService;

    public void sayBye(){
        System.out.println(helloService.getName()+" said bye to "+ name + "!");
    }

}
