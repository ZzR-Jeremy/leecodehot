package com.example.leecode.hot;

public class SolutionSixteen {
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 示例  1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     *
     * 示例 2：
     *
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     *
     * 示例 3：
     *
     * 输入：s = ""
     * 输出：0
     */
    //最值型动态规划题目
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] dp=new int[n];//是以I处括号为结尾的有效括号长度
        int max_len=0;
        //i从1开始（也就是从第二位开始），2个原因：
        //第一个单括号无效
        //防止i-1越界
        for(int i=1;i<n;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){//第一种情况: ...()
                    if(i<2) dp[i]=2;
                    else dp[i]=dp[i-2]+2;
                }else{//第二种情况: ((...))
                    if(i-1>0){
                        int pre_left=i-dp[i-1]-1;
                        if(pre_left>=0&&s.charAt(pre_left)=='('){
                            dp[i]=dp[i-1]+2;

                        //左括号前可能还存在有效括号：()((...))
                        if(pre_left-1>0){
                            dp[i]=dp[i]+dp[pre_left-1];
                        }
                        }
                    }
                }
            }
            max_len=Math.max(max_len,dp[i]);
        }
        return max_len;

    }
}
