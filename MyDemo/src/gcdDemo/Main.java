package gcdDemo;

import java.util.Scanner;

/**
 * Created by linxn on 2017/4/9.
 * 求最大公倍数&最大公约数
 */
public class Main {

    //返回最大公约数
    static int couGcd(int num1,int num2){
        if(num2 == 0){
            return num1;
        }else{
            return couGcd(num2, num1 % num2);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(), num2 = input.nextInt();
        //求最大公倍数
        int lcm = num1 * num2 / couGcd(num1, num2);
        System.out.println(lcm+" "+couGcd(num1, num2));
    }
}
