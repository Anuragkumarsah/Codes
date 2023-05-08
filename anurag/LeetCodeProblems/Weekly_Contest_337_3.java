package com.anurag.LeetCodeProblems;

import java.util.HashSet;
import java.util.Set;

public class Weekly_Contest_337_3 {
    public static int subset(int idx, int[] arr, Set<Integer> set, int k){
        if(idx==arr.length) {
            return 1;
        }
        int pick = 0;
        if(!set.contains(arr[idx] - k) && !set.contains(arr[idx] + k)) {
            set.add(arr[idx]);
            pick = subset(idx + 1, arr, set, k);
            set.remove(arr[idx]);
        }
        int not_pick = subset(idx+1, arr, set, k);
        return pick + not_pick;
    }
    public int beautifulSubsets(int[] nums, int k) {
//        int total = (int)(Math.pow(2, nums.length));
        return subset(0, nums, new HashSet<>(), k) -1;
    }
    public static void main(String[] args) {
        int[] nums = {10,4,5,7,2,1};
        int k = 3;
        Weekly_Contest_337_3 ob = new Weekly_Contest_337_3();
        System.out.println(ob.beautifulSubsets(nums, k));
    }
}
