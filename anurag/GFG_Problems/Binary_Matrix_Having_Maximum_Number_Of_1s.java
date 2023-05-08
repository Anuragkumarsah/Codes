package com.anurag.GFG_Problems;

public class Binary_Matrix_Having_Maximum_Number_Of_1s {
    public int[] findMaxRow(int[][] mat, int N) {
        int max=N, index = 0, max_index = 0;
        while(index < N && max > 0) {
            if(mat[index][max-1] == 0){
                index++;
            } else {
                max--;
                max_index = index;
            }
        }
        return new int[]{max_index, N-max};
    }
    public static void main(String[] args) {

    }
}
