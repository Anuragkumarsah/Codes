package com.anurag.Recurssion;

import java.util.HashMap;
import java.util.Map;

public class Combination_Sum_IV {
    static Map<Integer, Integer> map = new HashMap<>();
    public static int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
