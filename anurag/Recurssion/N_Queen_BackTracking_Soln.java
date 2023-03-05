package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class N_Queen_BackTracking_Soln {
    static void construct(char[][] board,List<List<String>> ans) {
        List<String> rowlist = new ArrayList<>();
        for (char[] chars : board) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                row.append(chars[j]);
            }
            rowlist.add(row.toString());

        }
        ans.add(rowlist);
    }
    public static boolean isSafe(int row, int col, char[][] board, int n){
        int copy_row = row;
        int copy_col = col;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = copy_row;
        col = copy_col;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        col = copy_col;
        while(row<n && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public static void solve(int col, char[][] board, int n, List<List<String>> ans){
        if(col == n){
            construct(board, ans);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row, col, board, n)){
                board[row][col]='Q';
                solve(col+1, board, n, ans);
                board[row][col]='.';
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i],'.');
        }
        solve(0, board, n, ans);
        int i = 1;
        for (List < String > it: ans) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
