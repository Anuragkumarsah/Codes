package com.anurag.Recurssion;

public class Valid_Sudoku {
    static boolean isValid(int row, int col, char[][] board, char number){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == number && i!=col) return false;
            if(board[i][col] == number && i!=row) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == number && 3*(row/3)+(i/3)!=row && 3*(col/3)+(i%3)!=col) return false;
        }
        return true;
    }
    static boolean solve_sudoku(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(!isValid(i, j, board, board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solve_sudoku(board));
    }
}
