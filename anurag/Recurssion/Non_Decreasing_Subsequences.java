package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Non_Decreasing_Subsequences {
    public void findSubsequences(int[] nums, int index, int lastNumber, List<Integer> list, List<List<Integer>> ans) {
        if(index == nums.length){
            if(list.size() < 2) return;
            ans.add(new ArrayList<>(list));
            return;
        }
        if(lastNumber <= nums[index]){
            list.add(nums[index]);
            findSubsequences(nums, index+1, nums[index], list, ans);
            list.remove(list.size() - 1);
        }
        if (index > 0 && list.size() > 0 && nums[index] == lastNumber) return;
        findSubsequences(nums, index+1, lastNumber, list, ans);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        List<List<Integer>> ans = new ArrayList<>();
        Non_Decreasing_Subsequences ob = new Non_Decreasing_Subsequences();
        ob.findSubsequences(nums,0,Integer.MIN_VALUE, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
