package com.example.leecode.hot;

public class SolutionTwentyTwo {
    public void rotate(int[][] martix){
        int n=martix.length;
        int[][] dummy=new int[n][n];
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                dummy[j][n-i-1]=martix[i][j];
            }
        }
        for (int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                martix[i][j]=dummy[i][j];
            }
        }
    }
    public void rotate1(int[][] martix){
        int n=martix.length;
        //先转置
        for(int i=0;i<n;++i){
            for (int j=0;j<i;j++){
                martix[i][j]=martix[i][j]^martix[j][i];
                martix[j][i]=martix[i][j]^martix[j][i];
                martix[i][j]=martix[i][j]^martix[j][i];
            }
        }
        //再垂直翻转
        for(int i=0;i<n;++i){
            for(int j=0,k=n-1;j<k;++j,--k){
                martix[i][j]=martix[i][j]^martix[i][k];
                martix[i][k]=martix[i][j]^martix[i][k];
                martix[i][j]=martix[i][j]^martix[i][k];
            }
        }
    }
}
