package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class Biweekly_Contest_104 {

    public long maximumOr(int[] nums, int k, int idx) {
        if(idx == nums.length) return 0;
        long pick = 0;
        if(k > 0)
            pick = maximumOr(nums, k-1, idx) | ((long) nums[idx] << 1);
        long not_pick = maximumOr(nums, k, idx+1) | ((long) nums[idx]);
        System.out.println(pick +" "+ not_pick);
        return Math.max(pick, not_pick);
    }

    public int matrixSum(int[][] nums) {
        for(int[] row: nums){
            Arrays.sort(row);
        }
        int ans = 0;
        for(int i=0;i<nums[i].length;i++){
            int max = 0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j][i] > max) {
                    max = nums[j][i];
                }
            }
            ans += max;
        }
        return ans;
    }
    public int countSeniors(String[] details) {
        int count = 0;
        for(String det: details) {
            int age = Integer.parseInt(det.substring(11, 13));
            if(age > 60) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(12|18|9);
        // 11111
    }
}
