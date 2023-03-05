package com.anurag.LeetCodeProblems;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Naming_a_Company {
    public long distinctNames(String[] ideas) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, ideas);
        Set<String> set1 = new HashSet<>();
        int[] set2 = new int[26];
        for (String idea : ideas) {
            set1.add(idea.substring(1));
            set2[idea.charAt(0)-'a']++;
        }
        int count = 0;
        for(int ch : set2){
            for(String str : set1){
                String s = (char)(ch+97) + str;
                if(!set.contains(s)) count+=(ch);
            }

        }
        return count;
    }
    public static void main(String[] args) {

    }
}
