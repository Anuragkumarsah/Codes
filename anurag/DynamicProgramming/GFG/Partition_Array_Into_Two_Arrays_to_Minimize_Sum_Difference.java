package com.anurag.DynamicProgramming.GFG;


import java.util.Arrays;

public class Partition_Array_Into_Two_Arrays_to_Minimize_Sum_Difference {
    public static int[][] isPossible(int[] nums, int target, int size){
        int[][] dp = new int[size][target+1];
        for(int i=0;i<size;i++){
            dp[i][0] = 1;
        }
        dp[0][nums[0]] = 1;
        for(int ind=1;ind<size;ind++){
            for(int j=1;j<=target;j++){
                int take = 0;
                if(j >= nums[ind]){
                    take = dp[ind-1][j - nums[ind]];
                }
                int notTake = dp[ind-1][j];
                dp[ind][j] = take + notTake;
            }
        }
        return dp;
    }
    public static int minDifference(int[] arr, int n) {
        int target = 0;
        for(int num : arr){
            target += num;
        }
        int[][] dp = isPossible(arr, target, n);
        System.out.println(Arrays.deepToString(dp));
        int min = Integer.MAX_VALUE;
//        for (int i = 0; i <target; i++) {
//            if(dp[n-1][i]){
//                int difference = Math.abs(target - 2*i);
//                min = Math.min(min, difference);
//            }
//        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int N = 4;
        int ans = minDifference(arr, N);
        System.out.println(ans);
    }
}
