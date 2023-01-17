package com.anurag.LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> ans = new ArrayList<>();
        //case 1: no overlapping case before the merge intervals
        //compare ending point of intervals to starting point of newInterval
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        //case 2: overlapping case and merging of intervals
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        // case 3: no overlapping of intervals after newinterval being merged
        while(i < n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};
        int[][] ans = insert(intervals, newInterval);
        for(int[] a : ans){
            System.out.println(a[0] + " "+ a[1]);
        }
    }
}
