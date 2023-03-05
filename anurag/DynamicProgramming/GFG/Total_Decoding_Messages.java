package com.anurag.DynamicProgramming.GFG;

import java.util.Arrays;

public class Total_Decoding_Messages {
    public int CountWays(char[] str, int index, int length) {
        if(index == length){
            return 1;
        }
        if(index > length) return 0;
        if(str[index] == '0') return 0;
        int slice_one = CountWays(str, index+1, length);
        int slice_two = 0;
        if(index+1 < length) {
            int two_digit = (str[index] - '0') * 10 + (str[index + 1] - '0');
            if(two_digit <= 26){
                slice_two = CountWays(str, index+2, length);
            }
        }
        return slice_one + slice_two;
    }
    public int CountWays_memoization(char[] str, int index, int length, int[] dp) {
        if(index == length){
            return 1;
        }
        if(index > length) return 0;
        if(str[index] == '0') return 0;
        if(dp[index] != -1) return dp[index];
        int slice_one = CountWays_memoization(str, index+1, length, dp);
        int slice_two = 0;
        if(index+1 < length) {
            int two_digit = (str[index] - '0') * 10 + (str[index + 1] - '0');
            if(two_digit <= 26){
                slice_two = CountWays_memoization(str, index+2, length, dp);
            }
        }
        return dp[index] = slice_one + slice_two;
    }
    public static void main(String[] args) {
        Total_Decoding_Messages ob = new Total_Decoding_Messages();
        String str = "123";
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        System.out.println(ob.CountWays(str.toCharArray(), 0, str.length()));
        System.out.println(ob.CountWays_memoization(str.toCharArray(), 0, str.length(), dp));
    }
}
