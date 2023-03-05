package com.anurag.DynamicProgramming.GFG;

import java.util.Arrays;

public class Walls_Coloring {
    public static int minCost(int[][] colors, int prev_color, int row, int[][] dp){
        //Write your code here
        if(row == 0){
            int min = (int) 1e9;
            for(int i=0;i<3;i++){
                if(prev_color != i){
                    min = Math.min(min, colors[0][i]);
                }
            }
            return min;
        }
        if(prev_color != 3 && dp[row][prev_color] != -1) return dp[row][prev_color];
        int min = (int) 1e9;
        for(int i = 0; i < 3; i++){
            if(i == prev_color) continue;
            int cost = minCost(colors, i, row-1, dp) + colors[row][i];
            min = Math.min(min, cost);
        }
        return dp[row][prev_color] = min;
    }
    public static void main(String[] args) {
        int[][] colors = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        int N = 3;
        int[][] dp = new int[N][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = minCost(colors, 3, N-1, dp);
        System.out.println(ans);
    }
}
