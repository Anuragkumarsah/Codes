package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    private static boolean isPalindrome(char[] s, int start, int end) {
//        System.out.println(start+" "+end);
        for(int i=start;i<=(start+end)/2;i++){
//            System.out.println(s[i] +" "+ s[end+start-i]);
            if(s[i] != s[end+start-i]) {
                return false;
            }
        }
        return true;
    }
    public static void partition(String s, int start, ArrayList<String> list, ArrayList<List<String>> ans) {
        if(start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
//        System.out.println(list);
        if(start > s.length()) return;
        for(int i=start;i<s.length();i++) {
            if (isPalindrome(s.toCharArray(), start, i)) {
//                System.out.println(s.substring(start, i + 1));
                list.add(s.substring(start, i + 1));
                partition(s, i+1, list, ans);
                list.remove(list.size() - 1);
            }
        }
//        System.out.println(isPalindrome(s.toCharArray(), 1, 2));
    }

    public static void main(String[] args) {
        ArrayList<List<String>> ans = new ArrayList<>();
        partition("a", 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
