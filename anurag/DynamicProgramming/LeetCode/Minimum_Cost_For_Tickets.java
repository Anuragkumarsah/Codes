package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;

public class Minimum_Cost_For_Tickets {
    public int minCost(int[] days, int index, int max_index, int[] costs, int ticketTill, int[][] dp) {
        if(index == max_index) return 0;

        if(dp[index][ticketTill] != -1) return dp[index][ticketTill];

        if(days[index] <= ticketTill) {
            return minCost(days, index+1, max_index, costs, ticketTill, dp);
        }
        int one_day_ticket = minCost(days, index+1, max_index, costs, days[index], dp) + costs[0];
        int seven_day_ticket = minCost(days, index+1, max_index, costs, days[index] + 6, dp) + costs[1];
        int thirty_day_ticket = minCost(days, index+1, max_index, costs, days[index] + 29, dp) + costs[2];
        return dp[index][ticketTill] = Math.min(one_day_ticket, Math.min(seven_day_ticket, thirty_day_ticket));
    }
    public int minCostTickets(int[] days, int[] costs) {
        int[][] dp = new int[days.length][days[days.length - 1] + 30];

        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return minCost(days, 0, days.length, costs, 0, dp);
    }
    public static void main(String[] args) {
        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = {3,13,45};
        Minimum_Cost_For_Tickets ob = new Minimum_Cost_For_Tickets();
        System.out.println(ob.minCostTickets(days, costs));
    }
}
