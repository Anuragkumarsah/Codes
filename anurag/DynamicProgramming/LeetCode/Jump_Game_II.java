package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Jump_Game_II {
    public static int jump_recursion(int[] nums, int index, int length) {
        if(index > length) return Integer.MAX_VALUE;
        if(index == length) return 0;
        if(nums[index] == 0) return Integer.MAX_VALUE;
        int min_steps = 100_000_000;
        for(int i=1;i<=nums[index];i++){
            int steps = jump_recursion(nums, index+i, length);
            min_steps = Math.min(min_steps, steps);
        }
        return min_steps + 1;
    }
    public static int jump_memoization(int[] nums, int index, int length, int[] dp) {
        if(index > length) return Integer.MAX_VALUE;
        if(index == length) return 0;
        if(dp[index] != -1){
            System.out.println(Arrays.toString(dp));
            return dp[index];
        }
        if(nums[index] == 0) return Integer.MAX_VALUE;
        int min_steps = 100_000_000;
        for(int i=1;i<=nums[index];i++){
            int steps = jump_memoization(nums, index+i, length, dp);
            min_steps = Math.min(min_steps, steps);
        }
        return dp[index] = min_steps + 1;
    }
    public static int jump_tabulation(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<=nums[i]; j++){
                
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int length = nums.length - 1;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, -1);
//        System.out.println(jump_recursion(nums, 0, length));
        jump_memoization(nums, 0, length, dp);

    }
}
