package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Unique_Paths {
    public static int unique_paths(int m, int n) {

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        int up = unique_paths(m-1, n);
        int left = unique_paths(m, n-1);

        return up + left;

    }
    public static int unique_paths_memoization(int m, int n, int[][] dp){
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != 0) return dp[m][n];
        if( m == 0 && n == 0) return dp[m][n] = 1;

        int up = unique_paths_memoization(m-1, n, dp);
        int left = unique_paths_memoization(m, n-1, dp);

        return dp[m][n] = up + left;

    }
    public static int unique_paths_tabulation(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) continue;;
                dp[i][j] = (i > 0 ? dp[i-1][j] : 0) + (j > 0 ? dp[i][j-1] : 0);
            }
        }
        return dp[m-1][n-1];
    }
    public static int unique_paths_tabulation_space_optimization(int m, int n){
//        int[] dp_row = new int[m];
        int ans = 0;
        int[] dp_col = new int[n];
        for(int i=0;i<m;i++){
            int prev_ans = 0;
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) {
                    ans = 1;

                }else {
                    ans = prev_ans + dp_col[j];
                }
                dp_col[j] = ans;
                prev_ans = ans;
            }
//            for(int x : dp_col) System.out.print(x+" ");
//            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows, 0);
        }
        System.out.println(unique_paths(m-1, n-1));
        System.out.println(unique_paths_memoization(m-1, n-1, dp));
        System.out.println(unique_paths_tabulation(m, n));
        System.out.println(unique_paths_tabulation_space_optimization(m, n));
//        unique_paths_tabulation_space_optimization(m ,n);
    }
}
