package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class Longest_Subsequence_With_Limited_Sum {
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sumDP = new int[nums.length + 1];
        sumDP[0] = 0;
        for(int i=1;i< sumDP.length;i++){
            sumDP[i] = sumDP[i - 1] + nums[i-1];
        }
        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            for(int j = 1;j<=sumDP.length;j++){
                if(j == sumDP.length || queries[i] < sumDP[j]){
                    ans[i] = j-1;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,1};
        int[] queries = new int[]{3,10,21};
        int[] ans = answerQueries(nums, queries);
        for(int num : ans){
            System.out.println(num);
        }
    }
}
