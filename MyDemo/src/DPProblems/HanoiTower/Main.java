package DPProblems.HanoiTower;

import java.util.Scanner;

/**
 * Created by linxn on 2017/4/9.
 */
public class Main {

    static void sloveH(int n, char a, char b, char c){
        if(n == 1){
            System.out.println("第 " + n + " 个盘子从" + a + "移动到" + c);
        }else{
            sloveH(n - 1, a, c, b);
            System.out.println("第 " + n + " 个盘子从" + a + "移动到" + c);
            sloveH(n -1, b, a, c);
        }

    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        sloveH(num, 'A', 'B', 'C');
    }
}
