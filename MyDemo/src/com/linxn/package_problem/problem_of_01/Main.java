package com.linxn.package_problem.problem_of_01;

/**
 * Created by Linxn on 2017/3/29.
 */
public class Main {
    public static void main(String[] args) {
//        int goodsNum = 8;
//        int maxWeight = 12;
//        int[] weight = {2,1,3,2,4,5,3,1};
//        int[] value = {13,10,24,15,28,33,20,8};
        int goodsNum = 5;
        int maxWeight = 12;
        int[] weight = {2,2,6,5,4};
        int[] value = {6,3,5,4,6};
        int[][] maxValue = new int[goodsNum + 1][maxWeight + 1];

        for (int i = 1; i <= maxWeight; i++) {
            for (int j = 1; j <= goodsNum; j++) {
                if(i < weight[j - 1]){
                    maxValue[j][i] = maxValue[j - 1][i];
                }else{
                    maxValue[j][i] = Math.max(maxValue[j - 1][i], maxValue[j - 1][i - weight[j - 1]] + value[j - 1]);
                }
            }
        }
        for (int i = 1; i <= goodsNum; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                System.out.print(maxValue[i][j]+" ");
            }
            System.out.println();
        }



    }
}
