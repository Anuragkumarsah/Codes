package com.anurag.LeetCodeProblems;

import java.util.*;

public class Merge_2D_Arrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] row : nums1){
            map.put(row[0], row[1]);
        }
        for(int[] row : nums2){
            if(map.containsKey(row[0])){
                map.put(row[0], map.get(row[0]) + row[1]);
            }else{
                map.put(row[0], row[1]);
            }
        }
        int[][] ans = new int[map.size()][2];
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans[count][0] = entry.getKey();
            ans[count][1] = entry.getValue();
            count++;
        }
        Arrays.sort(ans, Comparator.comparingInt(a -> a[0]));
        return ans;
    }
    public static void main(String[] args) {

    }
}
