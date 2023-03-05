package com.anurag.LeetCodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Count_the_Number_of_Fair_Pairs {
    public static Map<Integer, Integer[]> generateNumbers(String binary) {
        Map<Integer, Integer[]> map = new HashMap<>();
        int n = binary.length();
        for (int len = 0; len <= n; len++) {
            for (int i = 1; i <= Math.min(31, n - len); i++) {
                if(binary.charAt(i) == '0') continue;
                int num = Integer.parseInt(binary.substring(len, i + len), 2);
                if(!map.containsKey(num)){
                    map.put(num, new Integer[]{i, i+len -1});
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
        String s= "1001";
        Map<Integer, Integer[]> map = generateNumbers(s);
        Integer[] ans = map.get(4);
        System.out.println(ans[1]);
    }
}
