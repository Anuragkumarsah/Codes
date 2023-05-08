package com.anurag.DynamicProgramming.GFG;

public class Knapsack_Problem {
    static int knapsack(int ind, int W, int[] wt, int[] val, int n) {
        // your code here
        if(ind == n) return 0;
        int pick = 0, no_pick = 0;
        if(W <= wt[ind])
            pick = knapsack(ind+ 1, W - wt[ind], wt, val, n) + val[ind];
        no_pick = knapsack(ind+1, W, wt, val, n);
        return Math.max(pick, no_pick);
    }

    static int knapsack_memo(int ind, int W, int[] wt, int[] val, int n, int[] dp) {
        // your code here
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = 0, no_pick = 0;
        if(W <= wt[ind])
            pick = knapsack(ind+ 1, W - wt[ind], wt, val, n) + val[ind];
        no_pick = knapsack(ind+1, W, wt, val, n);
        return dp[ind] = Math.max(pick, no_pick);
    }
    public static void main(String[] args) {

    }
}
