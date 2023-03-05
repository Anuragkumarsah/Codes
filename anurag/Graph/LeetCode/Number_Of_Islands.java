package com.anurag.Graph.LeetCode;


public class Number_Of_Islands {
    public static void numIslands(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        if(visited[row][col]) return;
        visited[row][col] = true;
        numIslands(grid, visited, row+1, col);
        numIslands(grid, visited, row, col+1);
        numIslands(grid, visited, row-1, col);
        numIslands(grid, visited, row, col-1);
    }
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] != '0' && !visited[i][j]){
                    numIslands(grid, visited, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
