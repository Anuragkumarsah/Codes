package com.anurag.LeetCodeProblems;

public class weekly_341 {
    public int addMinimum(String word) {
        int count = 0;
        int idx = 0;
        while (idx < word.length()) {
            if (word.charAt(idx) != 'a' && word.charAt(idx) != 'b' && word.charAt(idx) != 'c') {
                idx++;
                continue;
            }
            if (word.charAt(idx) == 'a') {
                if (idx + 1 >= word.length() || word.charAt(idx + 1) != 'b') {
                    count++;
                } else {
                    idx++;
                }
                if (idx + 1 >= word.length() || word.charAt(idx + 1) != 'c') {
                    count++;
                } else {
                    idx++;
                }
            }
            else if (word.charAt(idx) == 'b') {
                if (idx - 1 < 0 || word.charAt(idx - 1) != 'a') {
                    count++;
                }
                if (idx + 1 >= word.length() || word.charAt(idx + 1) != 'c') {
                    count++;
                } else {
                    idx++;
                }
            }
            else if (word.charAt(idx) == 'c') {
                if (idx - 1 < 0 || word.charAt(idx - 1) != 'b') {
                    count++;
                } else {
                    idx--;
                }
                if (idx - 1 < 0 || word.charAt(idx - 1) != 'a') {
                    count++;
                } else {
                    idx--;
                }
            }
            idx++;
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
