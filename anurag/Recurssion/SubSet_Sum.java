package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSet_Sum {
    public static void subset(int idx, int sum, int[] arr, ArrayList<Integer> ans){
        if(idx==arr.length) {
            ans.add(sum);
            return;
        }
        subset(idx+1, sum + arr[idx ], arr, ans);
        subset(idx+1, sum, arr, ans);
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> ans = new ArrayList<>();
        subset(0, 0, arr, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
