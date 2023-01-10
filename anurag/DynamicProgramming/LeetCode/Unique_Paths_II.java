package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col) {
        if(row < 0 || col < 0 || obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0)
            return 1;
        int left = uniquePathsWithObstacles(obstacleGrid, row, col-1);
        int top = uniquePathsWithObstacles(obstacleGrid, row -1, col);
        return left+top;
    }

    public static int uniquePathsWithObstacles_memoization(int[][] obstacleGrid, int row, int col, int[][] dp) {
        if(row < 0 || col < 0 || obstacleGrid[row][col] == 1){
            return 0;
        }
        if(dp[row][col] != -1) return dp[row][col];
        if(row == 0 && col == 0)
            return dp[row][col] = 1;
        int left = uniquePathsWithObstacles_memoization(obstacleGrid, row, col-1, dp);
        int top = uniquePathsWithObstacles_memoization(obstacleGrid, row -1, col, dp);
        return dp[row][col] = left+top;
    }

    public static int uniquePathsWithObstacles_tabulation(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i< row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] == 1) continue;
                if( i == 0 && j == 0){
                    dp[0][0] = 1;
                    continue;
                }
                dp[i][j] = (i == 0 ? 0 : dp[i-1][j]) + (j == 0 ? 0 : dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }


    public static void main(String[] args) {
        int m = 5, n = 5;
        int[][] obstacleGrid = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        uniquePathsWithObstacles_memoization(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
    }
}
