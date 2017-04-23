package com.linxn.test_str;

/**
 * Created by Linxn on 2017/3/21.
 *
 * 理解String
 */
public class Main {
    public static void main(String[] args) {
        //下面两句声明相同，都是一个常量值
        //如果赋予其他值，则str指向另外一个常量值，即原来的“abc”还在内存中
//      String str = "abc";
        String str = new String("abc");
        str = "def";
        //字符串可以任意拼接
        str+=123;
        System.out.println(str);
    }

}
