package DPProblems.Fibonacci;

import java.util.Scanner;

/**
 * Created by linxn on 2017/4/9.
 */
public class Main {

    static int countF(int time){
        if(time == 2 || time == 1){
            return 1;
        }else{
            return countF(time - 1) + countF(time - 2);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(countF(num));
    }
}
