package com.anurag.LeetCode75;

public class Merge_Strings_Alternately {
    public static String mergeAlternately(String w1, String w2) {
        StringBuilder merged_word = new StringBuilder();
        for(int i=0, j=0; i<w1.length() || j < w2.length(); i++,j++) {
            if(i < w1.length()) merged_word.append(w1.charAt(i));
            if(j < w2.length()) merged_word.append(w2.charAt(j));
        }
        return merged_word.toString();
    }
    public static void main(String[] args) {

    }
}
