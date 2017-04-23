package DPProblems.DigitalTriangle;

import java.util.Scanner;

/**
 * Created by linxn on 2017/4/9.
 */
public class Main {
    //用递推求数字三角形
    static int CouDT(int[][] s){
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s.length - i; j++) {
                s[s.length - 1][j] = Math.max(s[s.length - 1][j],s[s.length - 1][j + 1]) + s[s.length - i - 1][j];
            }
        }

        return s[s.length - 1][0];
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] s = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                s[i][j] = input.nextInt();
            }
        }

        System.out.println(CouDT(s));


    }
}
