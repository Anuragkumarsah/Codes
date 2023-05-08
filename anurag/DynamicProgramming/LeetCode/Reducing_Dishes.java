package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Reducing_Dishes {
    public int find_time_coefficient(int index, int[] satisfaction, int time, int max_index,Integer[][] dp) {
        if(index == max_index) {
            return 0;
        }
        if(dp[index][time] != null) return dp[index][time];
        int pick = find_time_coefficient(index+1, satisfaction, time+1, max_index, dp) + satisfaction[index]*time;
        int not_pick = find_time_coefficient(index+1, satisfaction, time, max_index, dp);
        return dp[index][time] = Math.max(pick, not_pick);
    }


    // more optimized
    public int find_time_coefficient(int[] satisfaction) {
        int sum = 0, prevSum = 0, max = 0;
        Arrays.sort(satisfaction);
        for(int i=satisfaction.length-1;i>=0;i--) {
            sum += satisfaction[i] + prevSum;
            prevSum = prevSum + satisfaction[i];
            max = Math.max(sum, max);
        }
        return max;
    }
    public int maxSatisfaction(int[] satisfaction) {
        Integer[][] dp = new Integer[satisfaction.length][satisfaction.length];
        return find_time_coefficient(0, satisfaction, 1, satisfaction.length, dp);
    }
    public static void main(String[] args) {

    }
}
