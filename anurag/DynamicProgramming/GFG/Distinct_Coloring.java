package com.anurag.DynamicProgramming.GFG;

import java.util.Arrays;

public class Distinct_Coloring {
    public static long distinctColoring(int N, int prev_color, int[] r, int[] g, int[] b, long[][] dp){
        if(dp[prev_color][N] != -1) return dp[prev_color][N];
        if(N == 0){
            long min = Long.MAX_VALUE;
            if(prev_color == 0){
                min = Math.min(min, g[0]);
                min = Math.min(min, b[0]);
            } else if(prev_color == 1){
                min = Math.min(min, r[0]);
                min = Math.min(min, b[0]);
            } else {
                min = Math.min(min, g[0]);
                min = Math.min(min, r[0]);
            }
            return dp[prev_color][N] = min;
        }
        long mini = Long.MAX_VALUE;

        long red, green, blue;
        if (prev_color!=0){
            red = r[N] + distinctColoring(N - 1, 0, r, g, b, dp);
            mini = red;
        }
        if (prev_color!=1){
            green = g[N] + distinctColoring(N - 1, 1, r, g, b, dp);
            mini = Math.min(mini, green);
        }
        if (prev_color!=2){
            blue = b[N] + distinctColoring(N - 1, 2, r, g, b, dp);
            mini = Math.min(mini, blue);
        }
        return dp[prev_color][N] = mini;
    }
    public static long distinctColoring_tabulation(int N, int[]r, int[]g, int[]b){
        //code here
        long[][] dp = new long[N][3];
        dp[0][0] = r[0];
        dp[0][1] = g[0];
        dp[0][2] = b[0];
        for(int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b[i];
        }
        long min = Long.MAX_VALUE;
        for(int i=0;i<3;i++){
            min = Math.min(min, dp[N-1][i]);
        }
        return min;
    }
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        long[][] dp = new long[4][N+1];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        return distinctColoring(N-1, 3, r, g, b, dp);
    }
    public static void main(String[] args) {
        int[] r = {1, 1, 1};
        int[] g = {2, 2, 2};
        int[] b = {3, 3, 3};
        int N = 3;
        System.out.println(distinctColoring_tabulation(N, r, g, b));
    }
}
