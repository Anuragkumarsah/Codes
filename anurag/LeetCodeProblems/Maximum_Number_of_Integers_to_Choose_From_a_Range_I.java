package com.anurag.LeetCodeProblems;

import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Integers_to_Choose_From_a_Range_I {
    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int num: banned){
            set.add(num);
        }
        int cur_sum = 0, count = 0;
        for(int i=1;i<=n;i++){
            if(cur_sum >= maxSum || i > maxSum) break;
            if(!set.contains(i) && (cur_sum+i <= maxSum)){
                cur_sum += i;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] banned = {1,6,5};
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }
}
