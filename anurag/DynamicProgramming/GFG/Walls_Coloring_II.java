package com.anurag.DynamicProgramming.GFG;

import java.util.Arrays;

public class Walls_Coloring_II {
    public static int minCost(int [][] costs, int row, int prev_color, int[][] dp, int K) {

        if(dp[row][prev_color] != -1) return dp[row][prev_color];

        if(row == 0) {
            int min = Integer.MAX_VALUE;
            for(int color = 0; color <= K; color++) {
                if(color == prev_color) continue;
                min = Math.min(min, costs[0][color]);
            }
            return min;
        }

        int min_ans = Integer.MAX_VALUE;

        for(int color = 0; color <= K; color++) {
            if(color != prev_color){
             int cost = minCost(costs, row - 1, color, dp, K) + costs[row][color];
             min_ans = Math.min(min_ans, cost) ;
            }
        }
        return dp[row][prev_color] = min_ans;
    }
    public static void main(String[] args) {
        int[][] costs = {{1, 5, 7},
                        {5, 8, 4},
                        {3, 2, 9},
                        {1, 2, 4}};
        int N = costs.length;
        int K = costs[0].length;
        int[][] dp = new int[N+1][K+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(minCost(costs, N-1, K, dp, K-1));
    }
}
