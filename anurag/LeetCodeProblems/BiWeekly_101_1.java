package com.anurag.LeetCodeProblems;

import java.util.*;

public class BiWeekly_101_1 {

    public  boolean check(String s) {
        boolean one = false;
        int count0 = 0, count1 = 0;
        for(int i=0;i<s.length();i++){

            if(one && s.charAt(i) == '0'){
                return false;
            } else if(s.charAt(i) == '0'){
                count0++;
            } else if(s.charAt(i) == '1'){
                count1++;
                one = true;
            }
        }
        return count0 == count1;
    }

    public int findTheLongestBalancedSubstring(String s) {

        int max = 0;
        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                if(check(sb.toString())) {
                    max = Math.max(max, sb.length());
                }
            }
        }
        return max;
    }




    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<Set<Integer>> set_list = new ArrayList<>();
        set_list.add(new HashSet<>());
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int itr = 0;
            while (itr < res.size()) {
                Set<Integer> set = set_list.get(itr);
                if (set.contains(num) && itr == res.size() - 1) {
                    res.add(new ArrayList<>());
                    set_list.add(new HashSet<>());
                    itr++;
                } else if(!set.contains(num)) {
                    set.add(num);
                    res.get(itr).add(num);
                    break;
                } else {
                    itr++;
                }
            }
        }
        return res;
    }



    public int miceAndCheese(int[] reward1, int[] reward2, int k, int ind, int max_ind, int[][] dp) {
        if(ind == max_ind) return 0;
        if(k == 0) return 0;
        if(dp[ind][k] != -1) return dp[ind][k];
        int pick = miceAndCheese(reward1, reward2, k-1, ind+1, max_ind, dp) + Math.max(reward1[ind], reward2[ind]);
        int not_pick = miceAndCheese(reward1, reward2, k, ind+1, max_ind, dp);
        return dp[ind][k] = Math.max(pick, not_pick);
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int[][] dp = new int[reward1.length][k+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return miceAndCheese(reward1, reward2, k, 0, reward1.length, dp);
    }






    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int len = s.length();
        int[] arr = new int[len];
        Map<Character, Integer> map = new HashMap<>();
        int itr = 0;
        for(char ch : chars.toCharArray()) {
            map.put(ch, vals[itr]);
            itr++;
        }
        itr = 0;
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                arr[itr] = map.get(ch);
            }else {
                arr[itr] = (ch-'a') + 1;
            }
            itr++;
        }

        int max = Integer.MIN_VALUE, max_end = 0;
        for(int i=0;i<len;i++) {
            max_end += arr[i];
            if(max < max_end) {
                max = max_end;
            }
            if(max_end < 0){
                max_end = 0;
            }
        }
        return max;
    }
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            if(set1.contains(num)) return num;
        }

        if(nums1[0] > nums2[0]) return (nums2[0] * 10 + nums1[0]);
        else return (nums1[0] * 10 + nums2[0]);
    }
    public static void main(String[] args) {
        BiWeekly_101_1 ob = new BiWeekly_101_1();
        System.out.println(ob.findMatrix(new int[]{8,8,8,8,2,4,4,2,4}));
    }
}
