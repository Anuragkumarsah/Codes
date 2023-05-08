package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSet_Sum {
    public static int subset(int idx, int sum, int[] arr, ArrayList<Integer> ans){
        if(idx==arr.length) {
            ans.add(sum);
            return 1;
        }
        int pick = subset(idx+1, sum + arr[idx], arr, ans);
        int not_pick = subset(idx+1, sum, arr, ans);
        return pick + not_pick;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 10, 1, 1, 1};
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(subset(0, 0, arr, ans));
        Collections.sort(ans);
//        System.out.println(ans);
    }
}
