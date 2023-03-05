package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class House_Robber_IV {
    public static int minCapability(int[] nums, int k, int count, int index, int max, int[][] dp) {

//        if(count == k) return max;
        if(index >= nums.length && count == 0) return Integer.MAX_VALUE;
        if(index >= nums.length || count >= k) return max;
        if(dp[index][count] != -1) return dp[index][count];
        int pick = minCapability(nums, k, count+1, index+2, Math.max(max, nums[index]), dp);
        int notPick = minCapability(nums, k, count, index+1, max, dp);
        return dp[index][count] = Math.min(pick, notPick);
    }
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;
        int[][] dp = new int[nums.length][k];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(minCapability(nums, k, 0, 0, Integer.MIN_VALUE, dp));
//        for(int[] row : dp){
//            for(int col : row) System.out.print(col +" ");
//            System.out.println();
//        }
    }
}
