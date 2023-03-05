package com.anurag.GFG_Problems;

public class Valid_Compressed_String {
    static int checkCompressed(String S, String T) {
        int s_len = S.length(), t_len = T.length(), index = 0, ind = 0;
        while(ind < s_len) {
            char ch = T.charAt(index);
            if(ch >= 'A'){
                ++index;
                if(ch != S.charAt(ind)) return 0;
                ++ind;
            } else {
                int num = 0;
                while(ch < 'A'){
                    num = (num*10) + ch - '0';
                    ++index;
                    if(index >= t_len) break;
                    ch = T.charAt(index);
                }
                ind += num;
            }
            if(ind > s_len) return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        String s = "WODLAOFGPIGBWAALVZAHNTQGSRIUAJBYHLZSEVSIPSVGCKZPKKIOEHTUGRNMNRJZPCOCEHWYXYOMEPKHZVTCIIGZOWMVCOEWCTEHWOOQRYQCUIMBJDWJYXVZETZACERBFYDHTMENUJDKVZHPDKMUHTTJYV", t = "WO8GBWAAL98WJYXVZETZA7HTM15TTJY1";
        System.out.println(checkCompressed(s, t));
    }
}
