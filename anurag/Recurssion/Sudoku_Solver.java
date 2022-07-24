package com.anurag.Recurssion;

public class Sudoku_Solver {
    static boolean isValid(int row, int col, char[][] board, char number){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == number) return false;
            if(board[i][col] == number) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == number) return false;
        }
        return true;
    }
    static boolean solve_sudoku(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '0'){
                    for (char c = '1'; c <= '9'; c++) {
                        if(isValid(i, j, board, c)){
                            board[i][j] = c;
                            if(solve_sudoku(board)){
                                return true;
                            }else{
                                board[i][j] = '0';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[][]{  {'3', '0', '6', '5', '0', '8', '4', '0', '0'},
                                        {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
                                        {'0', '8', '7', '0', '0', '0', '0', '3', '1'},
                                        {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
                                        {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
                                        {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
                                        {'1', '3', '0', '0', '0', '0', '2', '5', '0'},
                                        {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
                                        {'0', '0', '5', '2', '0', '6', '3', '0', '0'}  };
            solve_sudoku(board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]+", ");
                }
                System.out.println();
            }

    }
}
