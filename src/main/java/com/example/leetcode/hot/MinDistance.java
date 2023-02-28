package com.example.leetcode.hot;

/**
 * 给定两个单词word1和word2，请返回将word1转换成word2所使用的最少操作数
 */
public class MinDistance {
    /**
     * 动态规划
     * dp[i][j] word1中前i个字符，变换到word2中前j个字符，最短需要操作的次数
     * word1和word2一个字母都没有，即全增加全删除的情况，所以预留dp[0][j]和dp[i][0]
     * 从 i j相邻的三个值中找一个最小值加1 分别是
     * 上方i-1 j 删除操作
     * 左侧i j-1 增加操作
     * 左上方 更新操作
     */
    public int minDistance(String word1,String word2){
        int length1=word1.length();
        int length2=word2.length();
        //定义动态规划数组
        int[][] dp=new int[length1+1][length2+1];
        //定义边界条件
        //第一列初值 每一个元素都减去本身拥有的元素的个数变成 空字符串
        for(int i=1;i<=length1;++i){
            dp[i][0]=dp[i-1][0]+1;
        }
        //第一行赋值
        for (int j=1;j<=length2;++j){
            dp[0][j]=dp[0][j-1]+1;
        }
        //状态转移方程
        for(int i=1;i<=length1;++i){
            for (int j=1;j<=length2;++j){
                dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[length1][length2];
    }
}
