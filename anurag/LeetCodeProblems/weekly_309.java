package com.anurag.LeetCodeProblems;

public class weekly_309 {
//    static int ans = 0;
//    public void numberOfWays(int startPos, int endPos, int k, int idx) {
//        if(startPos + k == endPos){ ans++; return;}
//        if(idx == k){
////            System.out.println(startPos +" "+endPos);
//            if(startPos == endPos){
//                ans++;
//            }
//            return;
//        }
////        if(Math.abs(endPos - startPos) > idx-k) return;
//        numberOfWays(startPos+1, endPos, k, idx+1);
//        numberOfWays(startPos-1, endPos, k, idx+1);
//    }
    public static int longestNiceSubarray(int[] nums) {
        int sum, xor, max = 1;
        for(int i=0;i<nums.length;i++){
            sum = nums[i]; xor = nums[i];
            for(int j=i+1;j<nums.length;j++){

                sum += nums[j];
                xor = xor^nums[j];
                if(sum!=xor){
                    System.out.println(j+" "+i);
                    max = Math.max(max, j-i);
                    break;
                }
            }
            if(nums.length - i < max) break;
        }
        return max;
    }
    public static void main(String[] args) {
//        int startPos = 1, endPos = 1000, k = 999;
//        weekly_309 ob = new weekly_309();
//        ob.numberOfWays(startPos, endPos, k, 0);
//        System.out.println(ans);
            int[] nums = {1,3,8,48,10};
        System.out.println("ans:" +longestNiceSubarray(nums));
    }
}
