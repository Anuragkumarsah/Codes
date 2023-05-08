package com.anurag.LeetCodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//class Pair {
//    public int row, col;
//    public Pair(int row, int col) {
//        this.row = row;
//        this.col = col;
//    }
//}
public class weekly_343 {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] row_score = new int[mat.length];
        int[] col_score = new int[mat[0].length];
        Arrays.fill(row_score, mat[0].length);
        Arrays.fill(col_score, mat.length);

        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
//        System.out.println(Arrays.toString(col_score));
        for(int i=0;i<arr.length;i++) {
            int[] row_col = map.get(arr[i]);
            if(row_score[row_col[0]]-1 == 0 || col_score[row_col[1]]-1 == 0) return i;
//            System.out.println(row_col[1]);
            row_score[row_col[0]]--;
            col_score[row_col[1]]--;
        }
        return arr.length-1;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{4,3,5},{1,2,6}};
        int[] arr = new int[] {1,4,5,2,6,3};
        System.out.println(firstCompleteIndex(arr, mat));
    }
}
