package com.anurag.LeetCodeProblems;

import java.util.PriorityQueue;

public class Minimize_Deviation_in_Array {
    public static int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) a *= 2;
            pq.add(-a);
            mi = Math.min(mi, a);
        }
        while (true) {
            assert pq.peek() != null;
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) break;
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,5,20,3};
        System.out.println(minimumDeviation(nums));
    }
}
