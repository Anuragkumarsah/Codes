package com.anurag.LeetCodeProblems;

import java.util.Arrays;

public class Successful_Pairs_of_Spells_and_Potions {
    public int BSearch(int[] potions, int spell, long success) {
        int left = 0, right = potions.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            long mixed_spell = (long) potions[mid] * spell;
            if(mixed_spell >= success) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int potion_len = potions.length;
        for(int i=0;i<spells.length;i++) {
            int start_success = BSearch(potions, spells[i], success);
            ans[i] = potion_len - start_success;
        }
        return ans;
    }
    public static void main(String[] args) {
        Successful_Pairs_of_Spells_and_Potions ob = new Successful_Pairs_of_Spells_and_Potions();
        int[] spells = {3,1,2}, potions = {8,5,8};
        long success = 16;
        System.out.println(Arrays.toString(ob.successfulPairs(spells, potions, success)));
    }
}
