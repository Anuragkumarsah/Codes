package com.anurag.LeetCodeProblems;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Rounds_To_Complete_All_Tasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks){
            int count = map.getOrDefault(task, 0);
            map.put(task, count + 1);
        }
        int ans = 0;
        for(var entry : map.entrySet()){
            if(entry.getValue() == 1) return -1;
            int value = entry.getValue();
            int mod_value = entry.getValue() % 3;
            if(mod_value == 0){
                ans += (value / 3);
            } else {
                ans += ((value / 3) + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
