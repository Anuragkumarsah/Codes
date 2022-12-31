package com.anurag.DynamicProgramming.LeetCode;

public class Maximum_Product_Subarray {
    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<nums.length;i++){
            if(dp[i-1] == 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] * nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int mul : dp){
            max = Math.max(max, mul);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
