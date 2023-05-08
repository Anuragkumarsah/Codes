package com.anurag.LeetCodeProblems;

public class Weekly_Contest_337_2 {

    public int[] findPos(int[][] grid, int row, int col, int target, int n) {
        if(row + 1 < n && col + 2 < n && grid[row + 1][col + 2] == target) return new int[]{row+1, col+2};
        if(row - 1 >= 0 && col + 2 < n && grid[row - 1][col + 2] == target) return new int[]{row-1, col+2};
        if(row + 2 < n && col + 1 < n && grid[row + 2][col + 1] == target) return new int[]{row+2, col+1};
        if(row + 2 < n && col - 1 >= 0 && grid[row + 2][col - 1] == target) return new int[]{row+2, col-1};
        if(row - 2 >= 0 && col + 1 < n && grid[row - 2][col + 1] == target) return new int[]{row-2, col+1};
        if(row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == target) return new int[]{row-2, col-1};
        if(row + 1 < n && col - 2 >= 0 && grid[row + 1][col - 2] == target) return new int[]{row+1, col-2};
        if(row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == target) return new int[]{row-1, col-2};
        return new int[]{-1, -1};
    }
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length, target = 1, row = 0, col = 0;
        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                int[] pos = findPos(grid, row, col, target, n);
                if(pos[0] == -1) return false;
                row = pos[0];
                col = pos[1];
                target++;
                if(target == (n*n)) return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
