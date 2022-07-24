package com.anurag.Recurssion;

import java.util.ArrayList;
import java.util.List;

public class N_Queen_Dp_Tabulation_soln {

    public static void add(char[][] board,List<List<String>> ans){
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
    public static void solve(int row,int n,char[][] board,boolean[] cols,boolean[] nDiagnol,boolean[] rDiagnol,List<List<String>> ans){
        if(row==board.length){
            add(board,ans);
            return;
        }
        for(int col=0;col<n;col++){
            if(!cols[col] && !nDiagnol[row+col] && !rDiagnol[row-col+n-1]){
                cols[col]=true;
                nDiagnol[row+col]=true;
                rDiagnol[row-col+n-1]=true;
                board[row][col]='Q';
                solve(row+1,n,board,cols,nDiagnol,rDiagnol,ans);
                board[row][col]='.';
                cols[col]=false;
                nDiagnol[row+col]=false;
                rDiagnol[row-col+n-1]=false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0,n,board,cols,ndiag,rdiag,ans);
        System.out.println(ans);
    }
}
