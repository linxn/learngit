package com.linxn.STLDemo.set;

import java.util.*;

/**
 * Created by Linxn on 2017/3/28.
 */
public class Main {
    public static void main(String[] args) {
        Set set = new TreeSet();
        //Set set = new TreeSet(); 、、有序

        set.add("fgh");
        set.add("abc");
        set.add("cde");
        set.add("efg");
        set.add("aaaa");
        set.add("bbc");
        set.add("abb");
        set.add("abc"); //重复的abc,set会自动将其去掉
        System.out.println("size = "+ set.size());
        for(Iterator it = set.iterator();it.hasNext();){
            System.out.println("value = " + it.next().toString());
        }
        System.out.println("set = " + set);
        List list = new ArrayList();
        list.add("abc");
        list.add("aaa");
        list.add("fff");
        set.addAll(list); //将list中的值加入set,并去掉重复的abc
        System.out.println("size = "+ set.size() );
        for( Iterator   it = set.iterator();  it.hasNext(); )
        {
            System.out.println("value = "+it.next().toString());
        }
        String[] a = new String[10];
        System.out.println(a.length);
    }
}
