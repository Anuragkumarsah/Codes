package com.anurag.GFG_Problems;

public class Remove_And_Reverse {
    public static String removeReverse(String S) {
        Integer[] f=new Integer[26];
        Integer[] r=new Integer[26];
        int i=0;
        int j=S.length()-1;
        int flag=0;
        StringBuilder result=new StringBuilder();
        while(i < j)
        {
            if(flag==0)
            {
                while(i<S.length() && f[S.charAt(i)-'a']==null)
                {
                    f[S.charAt(i)-'a']=i;
                    i++;
                    if(i==j) break;
                }
                if(i<S.length()) f[S.charAt(i)-'a']=i;
                i++;
                flag=1;
            }

            else
            {
                while(j>-1 && r[S.charAt(j)-'a']==null)
                {
                    r[S.charAt(j)-'a']=j;
                    j--;
                    if(i==j) break;
                }
                if(j>-1) r[S.charAt(j)-'a']=j;
                j--;
                flag=0;
            }
            System.out.println("I am here");
        }

        while(i==S.length() || j==-1)
        {
            if(flag==0)
            {
                while(i<S.length() && f[S.charAt(i)-'a']==null)
                {
                    f[S.charAt(i)-'a']=i;
                    r[S.charAt(i)-'a']=i;
                    i++;
                }
                if(i<S.length())
                {
                    f[S.charAt(i)-'a']=i;
                    r[S.charAt(i)-'a']=i;
                }
                flag=1;
            }

            else
            {
                while(j>-1 && r[S.charAt(j)-'a']==null)
                {
                    f[S.charAt(j)-'a']=j;
                    r[S.charAt(j)-'a']=j;
                    j--;
                }
                if(j>-1)
                {
                    r[S.charAt(j)-'a']=j;
                    f[S.charAt(j)-'a']=j;
                }
                flag=0;
            }
        }

        for(i=0;i<S.length();i++)
        {
            if(f[S.charAt(i) - 'a'] != null && f[S.charAt(i)-'a']==i)
            {
                result.append(S.charAt(i));
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeReverse("ccbcceb"));
    }
}
