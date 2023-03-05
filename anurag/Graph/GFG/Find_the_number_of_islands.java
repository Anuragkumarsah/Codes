package com.anurag.Graph.GFG;

public class Find_the_number_of_islands {
    public static void numIslands(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        if(visited[row][col]) return;
        visited[row][col] = true;
        for(int row_change=-1;row_change<2;row_change++){
            for(int col_change=-1;col_change < 2; col_change++){
                numIslands(grid, visited, row+row_change, col+col_change);
            }
        }
    }
    public static void main(String[] args) {

    }
}
