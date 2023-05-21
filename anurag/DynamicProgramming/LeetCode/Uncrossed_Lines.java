package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Uncrossed_Lines {

    public int getSimilarIndex(int[] arr, int target, int idx, int len) {
        for(int i=idx; i<len; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }
    public int maxUncrossedLines_memoization(int[] nums1, int[] nums2, int idx1, int idx2, int len1, int len2, int[][] dp) {
        if(idx2 == len2 || idx1 == len1) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int sim_index = getSimilarIndex(nums2, nums1[idx1], idx2, len2);
        int draw = 0;
        if(sim_index != -1) {
            draw = maxUncrossedLines_memoization(nums1, nums2, idx1+1, sim_index+1, len1, len2, dp) + 1;
        }
        int not_draw = maxUncrossedLines_memoization(nums1, nums2, idx1+1, idx2, len1, len2, dp);
        return dp[idx1][idx2] = Math.max(draw, not_draw);

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2, int idx1, int idx2, int len1, int len2) {
        if(idx2 == len2 || idx1 == len1) return 0;
        int sim_index = getSimilarIndex(nums2, nums1[idx1], idx2, len2);
        int draw = 0;
        if(sim_index != -1) {
            draw = maxUncrossedLines(nums1, nums2, idx1+1, sim_index+1, len1, len2)+1;
        }
        int not_draw = maxUncrossedLines(nums1, nums2, idx1+1, idx2, len1, len2);
        return Math.max(draw, not_draw);

    }
    public static void main(String[] args) {
        int[] nums1 = {2,5,1,2,5}, nums2 = {10,5,2,1,5,2};
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1][len2];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        Uncrossed_Lines uncrossedLines = new Uncrossed_Lines();
        System.out.println(uncrossedLines.maxUncrossedLines_memoization(nums1, nums2, 0, 0, len1, len2, dp));
        System.out.println(uncrossedLines.maxUncrossedLines(nums1, nums2, 0, 0, len1, len2));
    }
}
