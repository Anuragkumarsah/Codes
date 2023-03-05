package com.anurag.LeetCodeProblems;

import java.util.*;
import java.util.stream.Collectors;

public class Biweekly_84 {
    public static long countBadPairs(int[] nums, int space) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(nums[0], (long)0);
        long ans = 1;
        long brek = 0;
        for (int i = 1; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                ans++;
                map.put(nums[i], (long)i);
            }else{
                ans = ans + (space - (i - map.get(nums[i]))+1)+1;
                brek = (space - (i - map.get(nums[i]))+1)+1;
                map.replace(nums[i], (long)i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] item1= new int[]{1,2,1,2,3,1};
        System.out.println(countBadPairs(item1, 3));
    }
}
