package com.anurag.LeetCodeProblems;

public class Detect_Capital {
    public boolean detectCapitalUse(String word) {
        String first_letter = word.substring(0,1), later_part = word.substring(1);
        boolean first_letter_case = false, later_part_case = false;
        boolean upperCase = false, lowerCase = false;
        for(int i=0; i<later_part.length();i++){
            if(later_part.charAt(i) < 'a' && !lowerCase){
                upperCase = true;
            } else if(later_part.charAt(i) < 'a' && lowerCase){
                return false;
            }else if(later_part.charAt(i) >= 'a' && upperCase){
                return false;
            } else{
                lowerCase = true;
            }
        }
        if(first_letter.charAt(0) < 'a') first_letter_case = true;
        if(upperCase && !lowerCase) later_part_case = true;

        return first_letter_case || !later_part_case;
    }
    public static void main(String[] args) {

    }
}
