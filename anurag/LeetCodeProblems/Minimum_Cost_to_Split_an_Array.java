package com.anurag.LeetCodeProblems;

public class Minimum_Cost_to_Split_an_Array {
    public static int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n];
        for (int num : nums) {
            cnt[num]++;
        }
        int nums_count = 0;
        for(int i=0;i<n;i++){
            if(cnt[i] == 1) cnt[i] = 0;
            nums_count += cnt[i];
        }
        int sub_count = 0, n_count = nums_count, min = Integer.MAX_VALUE;
        int[] s_count = new int[n];
        for(int i=0;i<n;i++){
            int count = s_count[nums[i]] + 1;
            if(cnt[nums[i]] - count == 1){
                n_count -= cnt[nums[i]];
                cnt[nums[i]] = 0;
            } else if(count == 1) n_count -= 1;
            sub_count += (count-1);

            s_count[nums[i]]++;

            min =Math.min( min, sub_count + n_count + (i == n-1 || i == 0 ? k : 2*k));
            System.out.println(i+" "+sub_count + " "+ n_count);
//            n_count += count;
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 2;
        System.out.println(minCost(nums, k));
    }
}
