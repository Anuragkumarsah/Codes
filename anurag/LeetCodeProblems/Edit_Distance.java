package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class Edit_Distance {
    public static int minDistance(String word1, String word2, int i, int j, int[][] dp) {
        if(i == 0) {
            return j + 1;
        }
        if(j == 0) {
            return i + 1;
        }
        if(dp[i-1][j-1] != -1) return dp[i-1][j-1];
        if(word1.charAt(i) == word2.charAt(j)) return minDistance(word1, word2, i-1, j-1, dp);
        int insert = minDistance(word1, word2, i, j-1, dp) ;
        int delete = minDistance(word1, word2, i-1, j, dp) ;
        int replace = minDistance(word1, word2, i-1, j-1, dp);
        return dp[i-1][j-1] = Math.min(insert, Math.min(delete, replace)) + 1;
    }
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int i = word1.length() - 1, j = word2.length() - 1;
        int[][] dp = new int[i][j];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(minDistance(word1, word2, i, j, dp));
    }
}
