package com.anurag.DynamicProgramming.LeetCode;

import java.util.ArrayList;

public class Solving_Questions_With_Brainpower {
    public long mostPoints(int[][] questions, int idx, int len, Integer[] dp) {
        if(idx == len-1) return questions[idx][0];
        if(idx >= len) return 0;
        if(dp[idx] != null) return dp[idx];
        long solve = mostPoints(questions, idx + questions[idx][1], len, dp) + questions[idx][0];
        long not_solve = mostPoints(questions, idx+1, len, dp);
        return Math.max(solve, not_solve);
    }
    public static void main(String[] args) {
    }
}
