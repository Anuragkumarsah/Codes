package com.anurag.DynamicProgramming.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Rearranging_Fruits {
    public long minCost(int[] basket1, int[] basket2) {
        if(basket1.length != basket2.length) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<basket1.length;i++){
            if(map.containsKey(basket1[i])) {
                int cnt = map.get(basket1[i]);
                map.put(basket1[i], cnt + 1);
            }else{
                map.put(basket1[i], 1);
            }
            if(map.containsKey(basket2[i])) {
                int cnt = map.get(basket2[i]);
                map.put(basket2[i], cnt + 1);
            }else{
                map.put(basket2[i], 1);
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
