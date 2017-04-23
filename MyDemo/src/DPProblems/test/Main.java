package DPProblems.test;

import java.util.Scanner;

/**
 * Created by linxn on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int pass = num * 3 / 5;
        if(num * 3 % 5 != 0){
            pass++;
        }
        double[][] re = new double[num + 1][num + 1];
        double[] p = new double[num + 1];
        for (int i = 0; i < num; i++) {
            p[i + 1] = ((float)input.nextInt() / 100);
        }
        re[0][0] = 1;
        for (int i = 1; i <= num; i++) {
            re[i][0] = (1 - p[i]) * re[i - 1][0];
        }
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                re[i][j] = re[i - 1][j] * (1 - p[j]) + re[i - 1][j - 1] * p[j];
            }
        }
        float result = 0;
        for (int i = pass; i <= num; i++) {
            result += re[num][i];
        }
        System.out.println(result);
    }
}


