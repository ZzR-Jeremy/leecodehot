package com.example.leetcode.zuo;

public class utilZuo {
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr=new int[(int) ((maxSize+1)*Math.random())];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int) ((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
        }
        return arr;
    }
}
