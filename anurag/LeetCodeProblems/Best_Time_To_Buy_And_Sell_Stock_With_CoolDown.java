package com.anurag.LeetCodeProblems;

public class Best_Time_To_Buy_And_Sell_Stock_With_CoolDown {
    public static int maxProfit(int[] prices, int idx, boolean buy, int[][] dp) {
        // if I am past the last index I return the sum
        if(idx >= prices.length) return 0;
        // if I already calculated the sum then I just return the sum
        if(dp[idx][buy?1:0] != -1) return dp[idx][buy?1:0];
        // At any given instance I can either buy or sell depending on the condition
        // if I previously bought the stocks then I will be either able to sell the stocks
        // or I go to cool-down, so I choose to buy or sell accordingly, if I buy then
        // I subtract the price of the stock from my sum, else if I sell then I'll add the
        // price into the sum.
        // If I sell then the next day I will one cool-down So I skip the next day
        int buyOrSell = maxProfit(prices, idx+(buy ? 1 : 2), !buy, dp)+(buy ? -prices[idx] : prices[idx]);
        // In this period I try by going to cool-down, cool-down for me means, that I don't
        // do anything of that day.
        int coolDown = maxProfit(prices, idx+1, buy, dp);
        // At last, I return the max sum of either buyOrSell or coolDown, and store it into the dp
        return dp[idx][buy?1:0] = Math.max(buyOrSell, coolDown);
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1};
        int[][] dp = new int[arr.length][2];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        System.out.println(maxProfit(arr, 0, true, dp));
    }
}
