package com.example.leetcode.hot;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class SolutionSix {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean ans=false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<=m;++i){
            for (int j=1;j<=n;++j){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if (matchs(s,p,i,j-1)){
                        dp[i][j]=dp[i-1][j]||dp[i][j];//dp[i-1][j-2]匹配了s末尾的一个字符，然后将*和*前面的字符扔掉；dp[i][j-2]没有匹配s中的任何字符，直接将*和*前面的字符扔
                    }else if(matchs(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public boolean matchs(String s,String p,int i,int j){
        if (i==0) return false;
        if(p.charAt(j-1)=='·') return true;
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
