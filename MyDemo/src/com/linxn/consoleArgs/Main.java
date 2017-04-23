package com.linxn.consoleArgs;

/**
 * Created by Linxn on 2017/3/20.
 * 未完成
 * 从控制台获得输入
 */
public class Main {
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("Usage: java Main operand1 operator operand2");
            System.exit(0);
        }
        int result = 0;
        switch (args[1].charAt(0)){
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case '*':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                break;
        }

        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);



    }

}
