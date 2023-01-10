package com.anurag.LeetCodeProblems;

public class Delete_Columns_To_Make_Sorted {
    public int minDeletionSize(String[] strs) {
        int ans_count = 0;
        for(int i=0;i< strs[0].length();i++){
            int char_value = strs[0].charAt(i) - 'a';
            for(String str : strs){
                int current_char_value = str.charAt(i);
                if(current_char_value < char_value){
                    ans_count++;
                    break;
                }
                else char_value = current_char_value;
            }
        }
        return ans_count;
    }
    public static void main(String[] args) {

    }
}
