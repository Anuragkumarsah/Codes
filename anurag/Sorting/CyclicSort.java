package com.anurag.Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 5, 4, 3, 2, 6, 7};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void Sort(int[] nums){
        int i = 0;
        while(i < nums.length-1){
            if(nums[i] == i+1){
                i++;
            } else {
                int index = nums[i]-1;
                swap(nums, i, index);
            }
        }
    }

    static void swap(int[] nums, int i, int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

}
