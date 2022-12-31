package com.anurag.DynamicProgramming;

public class Coding_Ninjas {

    // CODE Link:- https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

    public static int ninjaTraining(int n, int[][] points, int prev_task, int[][] dp) {
        if(dp[n][prev_task] != -1) return dp[n][prev_task];
        if(n == 0){
            int max = 0;
            for(int i = 0;i<=2;i++){
                if(i!=prev_task) max = Math.max(max, points[n][i]);
            }
            return dp[n][prev_task] = max;
        }
        int maxi = 0;
        for(int i=0;i<=2;i++){
            if(i!=prev_task){
                int task_val = points[n][i] + ninjaTraining(n-1, points, i,dp);
                maxi = Math.max(maxi, task_val);
            }
        }
        return dp[n][prev_task] = maxi;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] points = new int[][]{{10, 40, 70},{20, 50, 80}, {30, 60, 90}};
        int[][] dp = new int[n+1][3+1];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));
//        int prev_task = 3;
        for(int days=1;days<n; days++){
            for(int prev_task=0;prev_task<3;prev_task++){
                dp[days][prev_task] = 0;
//                if(prev_task != j){
//                    max = Math.max(max, dp[i-1][j]);
//                    prev_task = j
//                }
            }
        }
//        System.out.println(ninjaTraining(2, points, 3,dp));
    }
}
