package com.anurag.DynamicProgramming.LeetCode;


import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int max_current = 0;
        int max_so_far = nums[0];
        int min_current = 0;
        int min_so_far = nums[0];
        int total_sum = 0;
        for(int num : nums){
            total_sum += num;
            max_current = Math.max(max_current + num, num);
            min_current = Math.min(min_current + num, num);
            max_so_far = Math.max(max_so_far, max_current);
            min_so_far = Math.min(min_so_far, min_current);
        }
        if(max_so_far <= 0) return max_so_far;
        return Math.max(max_so_far, (total_sum - min_so_far));
    }
    public static void main(String[] args) {

    }
}
