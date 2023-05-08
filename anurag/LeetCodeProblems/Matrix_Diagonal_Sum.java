package com.anurag.LeetCodeProblems;

public class Matrix_Diagonal_Sum {
    public int diagonalSum(int[][] mat) {
//        int n = mat.length, sum = 0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i==j || i == n-j-1) {
//                    sum += mat[i][j];
//                }
//            }
//        }
//        return sum;

        int n = mat.length, sum = 0;
        for(int i=0;i<n;i++){
            sum += mat[i][i];
            sum += mat[i][n-1-i];
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
