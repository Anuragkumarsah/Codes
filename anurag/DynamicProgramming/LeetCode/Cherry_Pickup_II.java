package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Cherry_Pickup_II {

    public static int cherryPickup_recursion(int[][] grid, int robot1_col, int row, int robot2_col, int total_row, int total_col) {

        if(robot1_col < 0 || robot1_col > total_col || robot2_col < 0 || robot2_col > total_col) return Integer.MIN_VALUE;

        if(row == total_row){
            if(robot1_col == robot2_col) return grid[row][robot1_col];
            return grid[row][robot1_col] + grid[row][robot2_col];
        }


        int max_ans = 0;
        for(int col_change = -1; col_change <= 1; col_change++){
            for(int col_2_change = -1; col_2_change <= 1; col_2_change++){
                int result = cherryPickup_recursion(grid, robot1_col + col_change, row+1, robot2_col+col_2_change, total_row, total_col);
                if(robot1_col == robot2_col){
                    result += grid[row][robot1_col];
                }else{
                    result += grid[row][robot1_col] + grid[row][robot2_col];
                }
                max_ans = Math.max(max_ans, result);
            }
        }
        return max_ans;
    }

    public static int cherryPickup_memoization(int[][] grid, int robot1_col, int row, int robot2_col, int total_row, int total_col, int[][][] dp) {

        if(robot1_col < 0 || robot1_col > total_col || robot2_col < 0 || robot2_col > total_col) return Integer.MIN_VALUE;

        if(row == total_row){
            if(robot1_col == robot2_col) return grid[row][robot1_col];
            return grid[row][robot1_col] + grid[row][robot2_col];
        }

        if(dp[row][robot1_col][robot2_col] != -1) return dp[row][robot1_col][robot2_col];

        int max_ans = 0;
        for(int col_change = -1; col_change <= 1; col_change++){
            for(int col_2_change = -1; col_2_change <= 1; col_2_change++){
                int result = cherryPickup_memoization(grid, robot1_col + col_change, row+1, robot2_col+col_2_change, total_row, total_col, dp);
                if(robot1_col == robot2_col){
                    result += grid[row][robot1_col];
                }else{
                    result += grid[row][robot1_col] + grid[row][robot2_col];
                }
                max_ans = Math.max(max_ans, result);
            }
        }
        return dp[row][robot1_col][robot2_col] = max_ans;
    }

    public static int cherryPickup_tabulation(int[][] grid) {
        int total_col  = grid[0].length, total_row = grid.length;
        int[][][] dp = new int[total_row][total_col][total_col];
        for(int robot1_col = 0; robot1_col <= total_col-1; robot1_col++) {
            for (int robot2_col = 0; robot2_col <= total_col - 1; robot2_col++) {
                if(robot1_col == robot2_col){
                    dp[total_row - 1][robot1_col][robot2_col] = grid[total_row - 1][robot1_col];
                }else{
                    dp[total_row - 1][robot1_col][robot2_col] = grid[total_row - 1][robot1_col] + grid[total_row - 1][robot2_col];
                }
            }
        }
        for(int row = total_row - 2; row >= 0; row--){
            for(int robot1_col = 0; robot1_col <= total_col-1; robot1_col++){
                for(int robot2_col = 0; robot2_col <= total_col-1; robot2_col++){
                    int max = 0;
                    for(int col_change = -1; col_change <= 1; col_change++){
                        for(int col_2_change = -1; col_2_change <= 1; col_2_change++){
                            int result = 0;
                            if(robot1_col == robot2_col) result = grid[row][robot1_col];
                            else result = grid[row][robot1_col] + grid[row][robot2_col];
                            if(robot1_col + col_change >= 0 && robot1_col + col_change < total_col && robot2_col + col_2_change >=0 && robot2_col + col_2_change < total_col)
                                result += dp[row + 1][robot1_col + col_change][robot2_col + col_2_change];
                            else
                                result = Integer.MIN_VALUE;
                            max = Math.max(max, result);
                        }
                    }
                    dp[row][robot1_col][robot2_col] = max;
                }
            }
        }
        return dp[0][0][total_col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};

        int total_col  = grid[0].length, total_row = grid.length;

        int[][][] dp = new int[total_row][total_col][total_col];

        for(int[][] two_d : dp){
            for(int[] row : two_d){
                Arrays.fill(row, -1);
            }
        }

//        System.out.println(cherryPickup_memoization(grid, 0, 0, total_col-1, total_row - 1, total_col - 1, dp));
        System.out.println(cherryPickup_tabulation(grid));
    }
}
