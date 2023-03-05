package com.anurag.GFG_Problems;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Minimize_The_Sum {
    public long minimizeSum(int N, int[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.offer((long) arr[i]);
        }
        long addOn = 0, ans = 0;

        while(pq.size() > 1){
            long x = pq.poll();
            long y = pq.poll();
            ans += addOn+x+y;
            pq.offer(x+y);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
