package com.anurag.DynamicProgramming.GFG;

import java.util.Arrays;

public class Count_number_of_ways_to_jump_to_reach_end {

//     Link https://www.geeksforgeeks.org/count-number-ways-jump-reach-end/

//    Problem Statement

//    Given an array of numbers where each element represents
//    the max number of jumps that can be made forward from that element.
//    For each array element, count the number of ways jumps can be made from
//    that element to reach the end of the array. If an element is 0,
//    then a move cannot be made through that element.
//    The element that cannot reach the end should have a count “-1“.

    public static int find_path(int[] arr, int index, int[] count,int[] dp){
        if(arr.length - 1 == index){
            return count[0]++;
        }
        if(dp[index] != -1) {
            count[0] += dp[index];
            return count[0];
        }
        for(int i=1;i<=arr[index];i++){
            if(index + i > arr.length-1){
                break;
            }else{
                find_path(arr, index+i, count,dp);
            }
        }
        return dp[index] = count[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9, 1, 0, 7, 6, 8, 9};
//        int[] arr = new int[]{1,1,1};
        for (int i = 0; i < arr.length; i++) {
            int[] dp = new int[arr.length+1];
            Arrays.fill(dp, -1);
            int ans = find_path(arr, i, new int[1], dp);

            System.out.print (ans == 0 && i != arr.length-1 ? -1+" " : ans+" ");
        }
    }
}
