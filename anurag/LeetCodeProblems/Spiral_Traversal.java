package com.anurag.LeetCodeProblems;

public class Spiral_Traversal {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = {{1, 2, 3},{4,5,6},{7,8,9}};
        int row  = 0, col = 1, edge_row = n-1, edge_col = n-1, starting_row = 0, starting_col = 0;
        int[] ans = new int[n*n];
        ans[0] = matrix[0][0];
        int index = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(row == starting_row+1 && col == starting_col){
                    edge_row--;
                    edge_col--;
                    starting_row++;
                    starting_col++;
                }
                else if(col == starting_col){
                    row--;
                }
                else if(col == edge_col){
                    row++;
                }
                else if(row == edge_row){
                    col--;
                }
                else if(row == starting_row){
                    col++;
                }
                ans[index] = matrix[row][col];
                System.out.println(row+" "+col);
                index++;
            }
        }
        for(int r: ans){
            System.out.println(r+" ");
        }
    }
}
