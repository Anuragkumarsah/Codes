package com.anurag.DynamicProgramming.GFG;


import java.util.Arrays;

public class Subset_Sum_Problem {

    static Boolean isSubsetSum(int idx, int[] arr, int sum){
        if(sum == 0){
            return true;
        }
        if(idx == 0){
            return arr[idx] == sum;
        }
        boolean take = false;
        if(sum >= arr[idx]){
            take = isSubsetSum(idx-1, arr, sum-arr[idx]);
        }
        boolean notTake = isSubsetSum(idx-1, arr, sum);
        return take || notTake;
    }
    static Boolean isSubsetSum_memoization(int idx, int[] arr, int sum, int[][] dp){
        if(sum == 0){
            return true;
        }
        if(idx == 0) return arr[idx] == sum;
        System.out.println(Arrays.deepToString(dp));
        if(dp[idx][sum] != -1){

            return dp[idx][sum] != 0;
        }
        boolean take = false;
        if(sum >= arr[idx]){
            System.out.println(Arrays.deepToString(dp));
            take = isSubsetSum_memoization(idx-1, arr, sum-arr[idx], dp);
        }
        boolean notTake = isSubsetSum_memoization(idx-1, arr, sum, dp);
        dp[idx][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
    static Boolean isSubsetSum_tabulation(int idx, int[] arr, int sum){
        boolean[][] dp = new boolean[idx][sum+1];
        for(int i=0;i<idx;i++){
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int i=1;i<idx;i++){
            for(int j=1;j<=sum;j++){
                boolean take = false;
                if(j >= arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                boolean notTake = dp[i-1][j];
                dp[i][j] = take || notTake;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[idx-1][sum];
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1};
        int sum = 1;
        int idx = 6;
        int[][] dp = new int[idx+1][sum+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        isSubsetSum_memoization(idx-1, arr, sum, dp);

    }
}
