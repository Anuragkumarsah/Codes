package com.anurag.LeetCodeProblems;

public class Find_the_Town_Judge {
    public int findJudge(int n, int[][] trust) {
        int[] peeps = new int[n];
        int[] number_of_trusts = new int[n];
        for(int[] trust_pair : trust){
            peeps[trust_pair[0]-1]++;
            number_of_trusts[trust_pair[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(peeps[i] == 0 && number_of_trusts[i] == n-1) return i+1;
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
