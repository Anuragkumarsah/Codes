package com.anurag.DynamicProgramming.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Scramble_String {

    public Map<String, Boolean> map;
    public boolean checkScramble_memoization(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) return false;
        if(s1.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;

        String key = s1 + "*" + s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int len = s1.length();
        for(int i=1;i<len;i++) {
            if((checkScramble_memoization(s1.substring(0, i), s2.substring(0, i)) && checkScramble_memoization(s1.substring(i), s2.substring(i))) ||
                    (checkScramble_memoization(s1.substring(0, i), s2.substring(len-i)) && checkScramble_memoization(s1.substring(i), s2.substring(0, len-i)))){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
    public boolean checkScramble(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) return false;
        if(s1.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;

        int len = s1.length();
        for(int i=1;i<len;i++) {
            if((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0, i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0, len-i)))){
                return true;
            }
        }
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return checkScramble(s1, s2);
    }
    public static void main(String[] args) {

    }
}
