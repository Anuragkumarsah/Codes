package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {
    public static int minFallingPathSum(int[][] matrix, int row, int col, int n) {
        if(col > n || col < 0) return Integer.MAX_VALUE;
        if(row == 0) return matrix[0][col];
        int left_diagonal = minFallingPathSum(matrix, row - 1, col - 1, n);
        int right_diagonal = minFallingPathSum(matrix, row - 1, col + 1, n);
        int up = minFallingPathSum(matrix, row - 1, col, n);
        int min = Math.min(left_diagonal, Math.min(right_diagonal, up));
        return min + matrix[row][col];
    }
    public static int minFallingPathSum_memoization(int[][] matrix, int row, int col, int n, int[][] dp) {
        if(col > n || col < 0) return Integer.MAX_VALUE;
        if(row == 0) return matrix[0][col];
        if(dp[row][col] != -1) return dp[row][col];
        int left_diagonal = minFallingPathSum_memoization(matrix, row - 1, col - 1, n, dp);
        int right_diagonal = minFallingPathSum_memoization(matrix, row - 1, col + 1, n, dp);
        int up = minFallingPathSum_memoization(matrix, row - 1, col, n, dp);
        int min = Math.min(left_diagonal, Math.min(right_diagonal, up));
        return dp[row][col] = min + matrix[row][col];
    }
    public static int minFallingPathSum_tabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int row=0;row<n;row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0) {
                    dp[row][col] = matrix[row][col];
                    if (row == n - 1) {
                        ans = dp[row][col];
                    }
                    continue;
                }

                int left_diagonal = (col + 1) >= n ? Integer.MAX_VALUE : dp[row - 1][col + 1];
                int right_diagonal = col - 1 < 0 ? Integer.MAX_VALUE : dp[row - 1][col - 1];
                int down = dp[row - 1][col];
                int min = Math.min(left_diagonal, Math.min(right_diagonal, down));
                dp[row][col] = min + matrix[row][col];
                if (row == n - 1) {
                    ans = Math.min(ans, dp[row][col]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<n;i++){
            int cost = minFallingPathSum_memoization(matrix, n - 1, i, n-1, dp);
            min = Math.min(min, cost);
        }
        System.out.println(minFallingPathSum_tabulation(matrix));
        System.out.println(min);
    }
}
