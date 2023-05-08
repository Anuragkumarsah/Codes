package com.anurag.LeetCodeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class FrequencyTracker {

    Map<Integer, Set<Integer>> map;
    int[] freq;
    public FrequencyTracker() {
        this.map = new HashMap<>();
        this.freq = new int[30_00_00];
    }

    public void add(int number) {
        int frequency = freq[number];
        freq[number]++;
        if(map.containsKey(frequency)) {
            map.get(frequency).remove(number);
            if(map.get(frequency).size() == 0){
                map.remove(frequency);
            }
        }
        if(map.containsKey(frequency+1)){
            map.get(frequency+1).add(number);
        }else {
            Set<Integer> temp = new HashSet<>();
            temp.add(number);
            map.put(frequency+1, temp);
        }
    }

    public void deleteOne(int number) {
        int frequency = freq[number];
        if(frequency == 0) return;
        freq[number]--;
        if(map.containsKey(frequency)) {
            map.get(frequency).remove(number);
            if(map.get(frequency).size() == 0){
                map.remove(frequency);
            }
        }
        if(frequency-1 == 0) return;
        if(map.containsKey(frequency-1)){
            map.get(frequency-1).add(number);
        }else {
            Set<Integer> temp = new HashSet<>();
            temp.add(number);
            map.put(frequency-1, temp);
        }
    }

    public boolean hasFrequency(int frequency) {
        return map.containsKey(frequency);
    }
}
public class weekly_344 {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> prefix = new HashSet<>();
        Set<Integer> suffix = new HashSet<>();
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            prefix.add(nums[i]);
            ans[i] = prefix.size();
        }
        for(int i=nums.length-1;i>=0;i--) {
            ans[i] = ans[i] - suffix.size();
            suffix.add(nums[i]);
        }
        return ans;
    }

    public int[] colorTheArray(int n, int[][] queries) {
        int count = 0;
        int[] ans = new int[queries.length];
        int[] color = new int[n];
        for(int i=0;i<queries.length;i++) {
            int index = queries[i][0];
            int coloring = queries[i][1];
            if(color[index] != 0){
                if(index != 0 && color[index] == color[index-1]) count--;
                if(index != n-1 && color[index] == color[index+1]) count--;
            }
            if(index != 0 && coloring == color[index-1]) count++;
            if(index != n-1 && coloring == color[index+1]) count++;
            ans[i] = count;
            color[index] = coloring;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
