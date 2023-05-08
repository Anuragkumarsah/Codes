package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class Weekly_340 {
    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int sq_num = (int)Math.sqrt(n);
        for(int i=2;i<=sq_num;i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int len = nums.length;
        int ans = 0;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if(i == j || (len-i-1) == j) {
                    if(isPrime(nums[i][j])) {
                        ans = Math.max(ans, nums[i][j]);
                    }
                }
            }
        }
        return ans;
    }



    public int minimumVisitedCells(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        if(i > m-1 || j > n-1) return (int)1e9;
        if(i==m-1 && j==n-1){
            dp[i][j] = dp[i][j]+1;
            return 0;
        }

        if(grid[i][j] == 0){

            return (int)1e9;
        }

        if(dp[i][j] != -1) return dp[i][j];
        int down = (int) 1e9, right = (int) 1e9;
        for(int d=i+1;d<=grid[i][j]+i;d++) {
            down = Math.min(down, minimumVisitedCells(grid, d, j, m, n, dp));
        }
        for(int r=j+1;r<=grid[i][j]+j;r++) {
            right = Math.min(right, minimumVisitedCells(grid, i, r, m, n, dp));
        }
        return dp[i][j] = Math.min(down, right) + 1;
    }

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int ans = minimumVisitedCells(grid, 0, 0, m, n, dp);
        System.out.println(Arrays.deepToString(dp));
        return ans > (int) 1e5 ? -1 : ans+1;
    }
    public static void main(String[] args) {
        int[][] grid = {{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}};
        Weekly_340 ob = new Weekly_340();
        System.out.println(ob.minimumVisitedCells(grid));
    }
}
