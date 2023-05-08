package com.anurag.DynamicProgramming.LeetCode;

public class Restore_The_Array {
    int MOD = (int) 1e9 + 7;

    public int numberOfArrays_memo(String s, int k, int ind, int len, int[] dp) {
        if(ind == len) return 1;
        if(dp[ind] != -1) return dp[ind];
        if(s.charAt(ind) == '0') return 0;
        long num = 0;
        int ans = 0;
        for(int i=ind;i<len;i++) {
            num = num*10 + (s.charAt(i) - '0');
            if(num > k) break;
            ans = (ans + numberOfArrays_memo(s, k, i+1, len, dp)) % MOD;
        }
        return dp[ind] = ans;
    }
    public int numberOfArrays(String s, int k, int ind, int len) {
        if(ind == len) return 1;
        if(s.charAt(ind) == '0') return 0;
        long num = 0;
        int ans = 0;
        for(int i=ind;i<len;i++) {
            num = num*10 + (s.charAt(i) - '0');
            if(num > k) break;
            ans = (ans + numberOfArrays(s, k, i+1, len))%MOD;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
