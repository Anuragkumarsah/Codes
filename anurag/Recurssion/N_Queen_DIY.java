package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class N_Queen_DIY {
    public static void add(char[][] board,List<List<String>> ans){
        List<String> rowlist = new ArrayList<>();
        for (char[] chars : board) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                s.append(chars[j]);
            }
            rowlist.add(s.toString());
        }
        ans.add(rowlist);
    }
    public static void solve(int col, int n, char[][] board, List<List<String>> ans, boolean[] left, boolean[] upperD, boolean[] lowerD){
        if(col == n){
            add(board, ans);
        }
        for (int i = 0; i < n; i++) {
            if(!left[i] && !upperD[n-i+col-1] && !lowerD[i+col]){
                board[i][col] = 'Q';
                left[i] = true;
                upperD[n-i+col-1] = true;
                lowerD[i+col] = true;
                solve(col+1, n, board, ans, left, upperD, lowerD);
                board[i][col] = '.';
                left[i] = false;
                upperD[n-i+col-1] = false;
                lowerD[i+col] = false;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        boolean[] leftHoriznotal = new boolean[n];
        boolean[] upperDiagonal = new boolean[2*n-1];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, n, board, ans, leftHoriznotal, upperDiagonal, lowerDiagonal);
        System.out.println(ans);
    }
}
