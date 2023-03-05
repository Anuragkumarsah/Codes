package com.anurag.LeetCodeProblems;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class Number_Of_square_free_subsets {

    static final int MOD = 1000000007;

    public static int numSquarefreeSubsets(int[] nums) {
        int n = nums.length;
        long[] dp = new long[1 << n];
        Arrays.fill(dp, 1);
        for (int mask = 1; mask < (1 << n); mask++) {
            int i = Integer.numberOfTrailingZeros(mask);
            dp[mask] = (dp[mask ^ (1 << i)] + dp[mask]) % MOD;
            for (int j = i + 1; j < n; j++) {
                if ((mask & (1 << j)) != 0 && gcd(nums[i], nums[j]) > 1) {
                    dp[mask] = (dp[mask ^ (1 << i)] + dp[mask ^ (1 << j)]) % MOD;
                }
            }
        }
        return (int) ((dp[(1 << n) - 1] - 1 + MOD) % MOD);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] nums = {26,6,6};

        System.out.println(numSquarefreeSubsets(nums));
    }
}
