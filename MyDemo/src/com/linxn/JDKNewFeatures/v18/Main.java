package com.linxn.JDKNewFeatures.v18;
import java.util.*;

/**
 * Created by linxn on 2017/4/14.
 */


/*1、接口默认方法
        java8允许我们给接口添加一个非抽象的方法实现，只需要使用default关键字即可，这个特征又叫做拓展方法，示例如下：
interface Formula{
    double calcalate(int a);
    default double sqrt(int a){  //可以直接使用该方法
        return Math.sqrt(a);
    }
}*/

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("peter");
        names.add("anna");
        System.out.println(names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
//        names.sort();
        System.out.println(names);
    }


}
