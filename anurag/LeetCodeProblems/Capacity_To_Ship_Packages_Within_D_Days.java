package com.anurag.LeetCodeProblems;

public class Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;
        int start = Integer.MIN_VALUE, total = 0;
        for(int weight : weights) {
            start = Math.max(start, weight);
            total += weight;
        }
        int ans = Integer.MAX_VALUE;
        while(start < total) {
            int right = 0, sum = 0;
            int mid = start + ((total - start)/2);
            for(int i=0;i<days;){
                if(right == len){
                    ans = Math.min(ans, mid);
                    break;
                }
                if(sum > mid){
                    i++;
                    sum = 0;
                }
                sum += right;
                right++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
