package com.linxn.scanner;

/**
 * Created by Linxn on 2017/3/20.
 * 用Scanner类从控制台获得输入
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max = 0;
        int number[] = new int[1001];
        int count = input.nextInt();
        String a = "daf";
        a.length();
        for(int i = 0; i < count; i++){
            int num = input.nextInt();
            if(number[num] == 0){
                number[num] = 1;

            }

        }
        for(int i = 0 ; i < 1001; i++){
            if(number[i] == 1){
                System.out.println(i);
            }
        }

    }



}
