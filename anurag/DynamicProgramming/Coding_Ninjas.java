package com.anurag.DynamicProgramming;

import java.util.Arrays;

public class Coding_Ninjas {

    // CODE Link:- https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

    public static int ninjaTraining(int n, int[][] points, int prev_task, int[][] dp, int k) {
        if(dp[n][prev_task] != -1) return dp[n][prev_task];
        if(n == 0){
            int max = 0;
            for(int i = 0;i<k;i++){
                if(i!=prev_task) max = Math.max(max, points[n][i]);
            }
            return dp[n][prev_task] = max;
        }
        int maxi = 0;
        for(int i=0;i<k;i++){
            if(i!=prev_task){
                int task_val = points[n][i] + ninjaTraining(n-1, points, i,dp, k);
                maxi = Math.max(maxi, task_val);
            }
        }
        return dp[n][prev_task] = maxi;
    }
    public static void main(String[] args) {
        int n = 5, k=9;
        int[][] points = new int[][]{{31, 78, 90, 28, 56, 3, 57, 26, 60},{53, 69, 33, 76, 30, 58, 52, 57, 89}, {46, 4, 41, 4, 22, 65, 98, 3, 68},{66, 70, 78, 46, 87, 18, 63, 32, 6},{69, 54, 92, 12, 26, 59, 48, 87, 23}};
        int[][] dp = new int[n+1][k+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
//        dp[0][0] = Math.max(points[0][1], points[0][2]);
//        dp[0][1] = Math.max(points[0][0], points[0][2]);
//        dp[0][2] = Math.max(points[0][1], points[0][0]);
//        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));
////        int prev_task = 3;
//        for(int days=1;days<n; days++){
//            for(int prev_task=0;prev_task<k;prev_task++){
//                dp[days][prev_task] = 0;
////                if(prev_task != j){
////                    max = Math.max(max, dp[i-1][j]);
////                    prev_task = j
////                }
//            }
//        }
        System.out.println(ninjaTraining(n-1, points, k,dp, k));
    }
}
