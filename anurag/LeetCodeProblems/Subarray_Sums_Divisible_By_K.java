package com.anurag.LeetCodeProblems;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sums_Divisible_By_K {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i-1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : prefixSum){
            int mod = num % k;
            mod = mod < 0 ? mod + k : mod;
            int encountered = map.getOrDefault(mod, 0);
            map.put(mod, encountered + 1);
            count += encountered;
        }
//        for(int num : nums){
//           System.out.println((num) % k < 0 ? (num % k) + k: num %k);
////            System.out.println((num+k) % k);
//        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,-2,2,-4};
        int k = 6;
        Subarray_Sums_Divisible_By_K obj = new Subarray_Sums_Divisible_By_K();
        System.out.println((-6 / 5));
    }
}
