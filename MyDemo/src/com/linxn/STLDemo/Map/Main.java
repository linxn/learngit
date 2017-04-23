package com.linxn.STLDemo.Map;

import java.util.*;

/**
 * Created by Linxn on 2017/3/29.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int key, value, tmp;
        for (int i = 0; i < num ; i++) {
            key = input.nextInt();
            value = input.nextInt();
            if(map.containsKey(key)){
                tmp = map.get(key);
                map.put(key, value + tmp);
            }else{
                map.put(key, value);
            }
        }
        for (int i:map.keySet()
             ) {
            System.out.println(i + " " + map.get(i));
        }

    }


}
