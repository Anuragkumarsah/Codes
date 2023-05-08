package com.anurag.LeetCodeProblems;

public class Minimum_Time_to_Complete_Trips {
    public static boolean isValid(int[] time, int totalTrip, long givenTime) {
        long number_of_trips = 0;
        for(int bus_time : time) {
            number_of_trips += (givenTime / bus_time);
        }
        return number_of_trips >= totalTrip;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int min = Integer.MAX_VALUE;
        for(int num : time) {
            min = Math.min(num, min);
        }
        long lo = min, hi = (long) min * totalTrips;
        while(lo < hi) {
            long mid = (lo + hi) / 2;
            if(isValid(time, totalTrips, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {

    }
}
