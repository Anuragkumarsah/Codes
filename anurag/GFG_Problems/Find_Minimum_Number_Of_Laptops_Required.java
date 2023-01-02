package com.anurag.GFG_Problems;

import java.util.Arrays;

public class Find_Minimum_Number_Of_Laptops_Required {
    public int minLaptops(int N, int[] start, int[] end) {
        // We don't need to maintain the order when one meeting starts or ends
        // We just need at any point in time, what is the maximum number of
        // meetings are going on, so sort both the start time and end times
        Arrays.sort(start);
        Arrays.sort(end);
        // initialize the start pointers.....
        int start_pointer = 0, end_pointer = 0, count = 1, max = 0;
        // we will continue to check the if any new meeting will start till
        // start_pointer is less than length of the array
        while(start_pointer < N){
            // in here we check if a new meeting is starting, if new meeting is starting
            // we increment the meeting count as one more meeting is starting
            if(start[start_pointer] < end[end_pointer]) {
                count++;
                start_pointer++;

                // in here we check if a meeting is ending, if a meeting is ending, if a
                // meeting is ending then we decrement the meeting count

            }else if(start[start_pointer] >= end[end_pointer]) {
                count --;
                end_pointer++;
            }
            // we calculate the max count,as this represent the max number of meeting active
            // at the same time up to this point
            max = Math.max(max, count);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
