package com.anurag.Recurssion;

import java.util.ArrayList;

public class Rat_In_A_Maze {
    public static void findPath(int[][] m, int n, String path, int row, int col, ArrayList<String> ans) {
        if(row == n-1 && col == n-1) {
            ans.add(path);
            return;
        }
        if(row+1 < n && m[row+1][col] != 0){
            m[row][col] = 0;
            findPath(m, n, path+"D", row+1, col, ans);
            m[row][col] = 1;
        }
        if(col-1 >= 0 && m[row][col-1] != 0) {
            m[row][col] = 0;
            findPath(m, n, path + "L", row, col - 1, ans);
            m[row][col] = 1;
        }
        if(col+1 < n && m[row][col+1] != 0){
            m[row][col] = 0;
            findPath(m, n, path+"R", row, col+1, ans);
            m[row][col] = 1;
        }
        if(row-1 >= 0 && m[row-1][col] != 0){
            m[row][col] = 0;
            findPath(m, n, path+"U", row-1, col, ans);
            m[row][col] = 1;
        }
    }
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] m = new int[][] {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        findPath(m, 4, "", 0, 0, ans);
        if(ans.size() == 0) System.out.println(-1);
        else
        System.out.println(ans);
    }
}
