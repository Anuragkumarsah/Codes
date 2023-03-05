package com.anurag.Recurssion;

public class Subsequence_equals_K {
    static int check(int[] arr, int idx, int sum, int target){
        int count = 0;
        if(idx == arr.length){
            if(sum==target) {
                return 1;
            }
            return 0;
        }
            sum += arr[idx];
            count += check(arr, idx+1, sum, target);
            sum -= arr[idx];
            count += check(arr, idx+1, sum, target);
            return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2};
        System.out.println(check(arr, 0, 0,4));
    }
}
