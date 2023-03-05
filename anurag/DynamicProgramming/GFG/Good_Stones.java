package com.anurag.DynamicProgramming.GFG;

import java.util.HashSet;
import java.util.Set;

public class Good_Stones {
    public static Set<Integer> bad;
    public static Set<Integer> good;
    public static int goodStones(int n, int[] arr, int index) {
        // code here
        if(index > n || index < 0) {
            return 1;
        }
        if(arr[index] == -100_000) return 0;
        if(bad.contains(index)) return 0;
        if(good.contains(index)) return 1;
        int next = arr[index];
        arr[index] = -100_000;
        int good_bad = goodStones(n, arr, index + next);
        arr[index] = next;
        if(good_bad == 1) good.add(index);
        else bad.add(index);
        return good_bad;
    }
    public static void main(String[] args) {
        bad = new HashSet<>();
        good = new HashSet<>();
        int[] arr = {1, 0, -3, 0, -5, 0};
        int n = 6;
        for(int i=0;i<n;i++){
            goodStones(n - 1, arr, i);
        }
        System.out.println(good.size());

    }
}
