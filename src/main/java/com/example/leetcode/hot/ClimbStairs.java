package com.example.leetcode.hot;

/**
 * 假设正在爬楼梯 每次可以爬1到2个台阶，问有多少种不同的方法可以爬到楼顶
 */
public class ClimbStairs {
    //递归
    public int climbStairs1(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    /**
     * 记忆化递归设置一个数据组 存储已经计算出的值
     * 比如 计算爬到第三阶台阶时就用到了 第二节台阶计算出的值 4也用到了2
     * @param n
     * @return
     */
    public int climbStairs2(int n){
       int memo[]=new int[n+1];
        return  climbStairsMemo(n,memo);
    }
    private int climbStairsMemo(int n, int[] memo) {
        if (memo[n]>0){
            return memo[n];
        }
        if (n==1){
            memo[n]=1;
        }else if (n==2){
            memo[n]=2;
        }else{
            memo[n]=climbStairsMemo(n-1,memo)+climbStairsMemo(n-2,memo);
        }
        return memo[n];
    }
    //动态规划
    public int climbStairs3(int n){
        if(n==1) return 1;
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
    }
        return dp[n];
    }
    //动态规划 滚动数组
    public int climbStairs4(int n){
        if (n==1) return 1;
        int first=1,second=2;
        for (int i=3;i<=n;++i){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
    }


    }
