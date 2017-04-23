package com.linxn.jnaDemo;

/**
 * Created by linxn on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        double a = JNATestDll.instanceDll.Add(1,2);
        System.out.println(a);
    }
}
