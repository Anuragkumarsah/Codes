package com.anurag.DynamicProgramming.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

class Pair{
    int score;
    int age;
    public Pair(int score, int age){
        this.age = age;
        this.score = score;
    }
    public Pair(Pair pair){
        this.age = pair.age;
        this.score = pair.score;
    }
}

public class Best_Team_With_No_Conflicts {
    public int bestTeamScore(Pair[] arr, Pair min, int index, int len, int[] dp){
        if(index == len) return 0;


        int choose = 0;
        if(arr[index].age < min.age && arr[index].score > min.score){
            Pair new_min = new Pair(min);
            if(min.score > arr[index].score){
                new_min.score = arr[index].score;
                new_min.age = arr[index].age;
            }
            choose =   bestTeamScore(arr, new_min, index+1, len, dp) + arr[index].score;
        }
        int notChoose = bestTeamScore(arr, min, index+1, len, dp);
        return dp[index] = Math.max(choose, notChoose);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        Pair[] arr = new Pair[len];
        for(int i=0;i<len;i++){
            arr[i] = new Pair(scores[i], ages[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a.age));
        Pair min = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        return bestTeamScore(arr, min, 0, len, new int[len]);
    }
    public static void main(String[] args) {
        int[] scores = new int[]{4,5,6,5};
        int[] ages = new int[]{2,1,2,1};
        Best_Team_With_No_Conflicts ob = new Best_Team_With_No_Conflicts();
        System.out.println(ob.bestTeamScore(scores, ages));
    }
}
