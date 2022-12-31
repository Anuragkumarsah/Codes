package com.anurag.DynamicProgramming.LeetCode;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        // Will be using the two pointer approach, as we need to find the max area,
        // so we start with initial position as the most apart distance... left is 0
        // right is 0
        int l = 0, r = height.length-1;
        // a max variable to store the max till now area values
        int max = 0;
        // we will find the area till the left pointer is less than the right pointer
        while(l < r){
            // we calculate the water area
            int water_area = Math.min(height[l], height[r]) * (r-l);
            // store the max
            max = Math.max(max, water_area);
            // we are trying to use the two pointer approach, so to reduce the problem, we will
            // check which height is less, if left is less, then we will increase left, as finding
            // a better solution will be only possible if we try to find a bigger height, so accordingly
            // if height at right is less, then we decrement right. If both are equal we can do any of the above.
            if(height[l] > height[r]) r--;
            else if (height[l] < height[r]) l++;
            else l++;
        }
        // return the max value of water area
        return max;
    }
    public static void main(String[] args) {

    }
}
