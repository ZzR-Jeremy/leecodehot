package com.example.leecode.zhouyu;

/**
 * 计算素数个数
 */
public class Prime {
    //暴力算法
    public int bf(int n){
        int count=0;
        for (int i=2;i<n;++i){
            count+= isPrime(i) ? 1:0;
        }
        return count;
    }
    public boolean isPrime(int n){
        //判断一个数是不是素数只需要判断 到根号他为之
        for (int i=2;i*i<n;++i){
            if(n%i==0) return false;
        }
        return true;
    }

    //埃氏筛算
}
