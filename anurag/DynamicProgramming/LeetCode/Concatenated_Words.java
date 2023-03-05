package com.anurag.DynamicProgramming.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concatenated_Words {
    public boolean canBeFormed(String word, Set<String> set){
        for(int i=1;i<word.length();i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if(set.contains(prefix) && (set.contains(suffix) || canBeFormed(suffix, set)))
                return true;
        }
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(List.of(words));
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(canBeFormed(word, set)){
                ans.add(word);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Concatenated_Words ob = new Concatenated_Words();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat", "cat"};
        ob.findAllConcatenatedWordsInADict(words);
    }
}
