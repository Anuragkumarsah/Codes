package com.anurag.DynamicProgramming.LeetCode;

import java.util.*;

public class Triangle {
    public int minimumTotal_recursion(List<List<Integer>> triangle, int row, int col) {
        if(row == triangle.size() - 1) return triangle.get(row).get(col);
        int same_col_path = minimumTotal_recursion(triangle, row+1, col);
        int next_col_path = minimumTotal_recursion(triangle, row+1, col+1);
        return Math.min(same_col_path, next_col_path) + triangle.get(row).get(col);
    }
    public int minimumTotal_memoization(List<List<Integer>> triangle, int row, int col, List<List<Integer>> dp) {
        if(row == triangle.size() - 1) return triangle.get(row).get(col);
        if(dp.get(row).get(col) != -1) return dp.get(row).get(col);
        int same_col_path = minimumTotal_memoization(triangle, row+1, col, dp);
        int next_col_path = minimumTotal_memoization(triangle, row+1, col+1, dp);
        int ans = Math.min(same_col_path, next_col_path) + triangle.get(row).get(col);
        dp.get(row).set(col ,ans);
        return ans;
    }
    public int minimumTotal_tabulation(List<List<Integer>> triangle){
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=1;i<=n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(i, 0)));
        }
        dp.get(0).set(0, triangle.get(0).get(0));
        int ans = Integer.MAX_VALUE;
        for(int row = 1; row < n; row++){
            for(int col = 0; col <= row; col++){
                int get_prev = Math.min(col == 0 ? Integer.MAX_VALUE : dp.get(row-1).get(col-1), col == row ? Integer.MAX_VALUE : dp.get(row-1).get(col));
                dp.get(row).set(col, get_prev+triangle.get(row).get(col));
            }
        }
        for(int costs : dp.get(n-1)){
            ans = Math.min(ans, costs);
        }
//        System.out.println(dp);
        return ans;
    }
    public int minimumTotal_tabulation_better(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int row = n-1;row >= 0; row--){
            for(int col = 0; col <= row; col++){
                dp[row][col] = Math.min(dp[row+1][col+1], dp[row+1][col]) + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=1;i<=n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(i, -1)));
        }
        Triangle obj = new Triangle();
        System.out.println(obj.minimumTotal_recursion(triangle, 0, 0));
        System.out.println(obj.minimumTotal_memoization(triangle, 0, 0, dp));
        System.out.println(obj.minimumTotal_tabulation(triangle));
        System.out.println(obj.minimumTotal_tabulation_better(triangle));
    }
}
