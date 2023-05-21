package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Weekly_Contest_345 {

    public int maxMoves(int[][] grid, int row, int col, int[][] dp) {
        if(row >= grid.length || col >= grid[0].length) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int up_di = 0, down_di = 0, same_di = 0;
        if(row-1 >= 0 && col+1 < grid[0].length && grid[row][col] < grid[row-1][col+1])
            up_di = maxMoves(grid, row-1, col+1, dp) + 1;
        if(col+1 < grid[0].length && grid[row][col] < grid[row][col+1])
            same_di = maxMoves(grid, row, col+1, dp) + 1;
        if(row+1 < grid.length && col+1 < grid[0].length && grid[row][col] < grid[row+1][col+1])
            down_di = maxMoves(grid, row+1, col+1, dp) + 1;
        return dp[row][col] = Math.max(up_di, Math.max(down_di, same_di));
    }
    public int maxMoves(int[][] grid) {
        int max = 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        for(int i=0;i<grid.length;i++){
            int res = maxMoves(grid, i, 0, dp);
            max = Math.max(max, res);
        }
        return max;
    }
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int curr = 0, count = k, elements = n-1;
        visited[curr] = true;
        while(true) {
            int pass = (curr + k) % n;
            if(visited[pass]) break;
            visited[pass] = true;
            elements--;
            k += count;
            curr = pass;
        }
        int[] ans = new int[elements];
        int it = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans[it] = i+1;
                it++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
