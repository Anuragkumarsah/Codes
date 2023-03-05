package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Climbing_Stairs {
    public static int climbStairs(int n, int[] dp) {
        if(n < 0) return 0;
        if(n <= 3){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        int oneStep = climbStairs(n-1, dp);
        int twoStep = climbStairs(n-2, dp);
        return dp[n] = oneStep + twoStep;
    }
    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairs(3, dp));
    }
}
