package com.anurag.GFG_Problems;

public class Number_Of_Sub_arrays_Of_0s {
    public static long no_of_sub_arrays(int N, int [] arr) {
        long zero_count = 0, ans = 0;
        for(int num : arr) {
            if(num == 0) {
                zero_count++;
            } else {
                ans += ((zero_count * (zero_count+1)) / 2);
                zero_count = 0;
            }
        }
        ans += ((zero_count * (zero_count+1)) / 2);
        return ans;
    }
    public static void main(String[] args) {

    }
}
