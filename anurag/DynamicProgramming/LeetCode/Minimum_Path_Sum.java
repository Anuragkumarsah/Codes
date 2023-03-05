package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Minimum_Path_Sum {
    public static int minPathSum_recursion(int[][] grid, int row, int col) {
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        int left = minPathSum_recursion(grid, row, col-1);
        int right = minPathSum_recursion(grid, row-1, col);
        return Math.min(left, right) + grid[row][col];
    }
    public static int minPathSum_memoization(int[][] grid, int row, int col, int[][] dp) {
        if(row < 0 || col < 0) return Integer.MAX_VALUE;

        if(dp[row][col] != -1) return dp[row][col];

        if(row == 0 && col == 0) return dp[row][col] = grid[row][col];

        int left = minPathSum_memoization(grid, row, col-1, dp);
        int right = minPathSum_memoization(grid, row-1, col, dp);
        return dp[row][col] = Math.min(left, right) + grid[row][col];
    }

    public static int minPathSum_tabulation(int[][] grid){
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i == 0 && j == 0) dp[0][0] = grid[0][0];
                else {
                    dp[i][j] = Math.min((i == 0 ? Integer.MAX_VALUE : dp[i-1][j]) , (j == 0 ? Integer.MAX_VALUE : dp[i][j-1])) + grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        System.out.println(minPathSum_recursion(grid, row-1, col-1));
        System.out.println(minPathSum_memoization(grid, row-1, col-1, dp));
        System.out.println(minPathSum_tabulation(grid));
    }
}
