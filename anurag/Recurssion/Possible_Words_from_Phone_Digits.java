package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class Possible_Words_from_Phone_Digits {
    public static ArrayList<String> possibleWords(int[] arr, List<String> combi, int idx, ArrayList<String> ans, String str){
        if(str.length() == arr.length){
            ans.add(str);
            return ans;
        }
        for(int i=0;i<combi.get(arr[idx]-2).length();i++){
            possibleWords(arr, combi, idx+1, ans, str+combi.get(arr[idx]-2).charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> combi = new ArrayList<>();
        combi.add("abc");
        combi.add("def");
        combi.add("ghi");
        combi.add("jkl");
        combi.add("mno");
        combi.add("pqrs");
        combi.add("tuv");
        combi.add("wxyz");
        int[] arr = new int[]{2};
//        System.out.println(combi.get(arr[0]-2));
        ArrayList<String> ans = new ArrayList<>();
        possibleWords(arr, combi, 0, ans, "");
        System.out.println(ans);
    }
}
