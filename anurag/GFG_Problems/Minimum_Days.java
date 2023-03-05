package com.anurag.GFG_Problems;

public class Minimum_Days {
    public static int getMinimumDays(int N, String S, int[] P) {
        int last_changed = 0;
        int string_pointer = N-1, array_pointer = 0;
        while(string_pointer > 0) {
            while (string_pointer > 0 && (S.charAt(string_pointer) != S.charAt(string_pointer - 1))) string_pointer--;
            if(string_pointer == 0) return last_changed;
            int copy_array_pointer = array_pointer;
            while(array_pointer < N && (P[array_pointer] != string_pointer && P[array_pointer] != string_pointer-1)) array_pointer++;
            if(array_pointer == N) array_pointer = copy_array_pointer;
            else {
                last_changed = array_pointer+1;
            }
            string_pointer--;
        }
        return last_changed;
    }
    public static void main(String[] args) {
        int N = 6;
        String S = "sktbbd";
        int[] P = {5, 1, 0, 3, 4, 2};
        System.out.println(getMinimumDays(N, S, P));
    }
}
