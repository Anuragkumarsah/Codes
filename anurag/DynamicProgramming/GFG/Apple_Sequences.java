package com.anurag.DynamicProgramming.GFG;

public class Apple_Sequences {
    public static int appleSequence(int n, int m, String arr){
        int max = Integer.MIN_VALUE;
        int right = 0, start = 0, orange_count = 0;
        while(right < n){
            if(arr.charAt(right) == 'O') orange_count++;
            max = Math.max(max, right - start);
            while(orange_count > m){
                orange_count--;
                start++;
            }
            right++;
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
