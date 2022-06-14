package com.example.leecode.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class SolutionFive {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2) return s;
        int maxLen=1;
        int begin=0;
        boolean[][] dp=new boolean[len][len];
        String ans=null;
        char[] charArray=s.toCharArray();
        for(int i=0;i<len;++i){
            dp[i][i]=true;
        }
        for (int L=2;L<=len;++L){//L=j-i+1
            for (int i=0;i<len;++i){
                int j=L+i-1;
                if(j>=len) break;
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else{
                    if (j-i<3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && (j - i + 1) > maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        ans=s.substring(begin,begin+maxLen);
        return ans;
    }
}
