package com.anurag.GFG_Problems;

public class Unique_Paths_III {
//    int count = 0;
    public static void uniquePathsIII(int[][] grid, int row, int col, int covered, int total, int[] count) {
        if(grid[row][col] == 2){
            if(covered == total) count[0]++;
            return;
        }
        if(grid[row][col] == -1) return;

        if(row != grid.length-1){
            grid[row][col] = -1;
            uniquePathsIII(grid, row+1, col, covered+1, total, count);
            grid[row][col] = 0;
        }
        if(row != 0){
            grid[row][col] = -1;
            uniquePathsIII(grid, row-1, col, covered+1, total, count);
            grid[row][col] = 0;
        }
        if(col != grid[0].length-1){
            grid[row][col] = -1;
            uniquePathsIII(grid, row, col+1, covered+1, total, count);
            grid[row][col] = 0;
        }
        if(col != 0){
            grid[row][col] = -1;
            uniquePathsIII(grid, row, col-1, covered+1, total, count);
            grid[row][col] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{2,0}};
        int total_empty_squares = 0, start_row = -1, start_col = -1;
        for (int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) total_empty_squares++;
                if(grid[i][j] == 1){
                    start_row = i;
                    start_col = j;
                }
            }
        }
        int[] count = new int[1];
        uniquePathsIII(grid, start_row, start_col, 1, total_empty_squares, count);
        System.out.println(count[0]);
    }
}
