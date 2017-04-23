package com.linxn.STLDemo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linxn on 2017/3/28.
 */
public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc");
        list.add(0,"def");
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);
    }
}
