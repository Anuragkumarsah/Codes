package com.anurag.LeetCodeProblems;

public class Decrease_Elements_To_Make_Array_Zigzag {
    public static int movesToMakeZigzag(int[] nums) {
        int even_changes = 0, odd_changes = 0, n = nums.length;
        for(int i=0;i<n;i+=2) {
            if(nums[i] >= (i == n-1 ? Integer.MAX_VALUE : nums[i+1]) || nums[i] >= (i == 0 ? Integer.MAX_VALUE : nums[i-1]))
                even_changes += (nums[i] - Math.min(i == n-1 ? Integer.MAX_VALUE : nums[i+1], i == 0 ? Integer.MAX_VALUE : nums[i-1]) + 1);
        }
        for(int i=1;i<n;i+=2) {
            if(nums[i] >= (i == n-1 ? Integer.MAX_VALUE : nums[i+1]) || nums[i] >= nums[i-1])
                odd_changes += (nums[i] - Math.min( i == n-1 ? Integer.MAX_VALUE : nums[i+1], nums[i-1]) + 1);
        }
        return Math.min(even_changes, odd_changes);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(movesToMakeZigzag(nums));
    }
}
