package com.example.leetcode.zuo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        long[] zhi=new long[n];
        if(n<2){
            System.out.println(0);
            return;
        }
        Map<Long, Long> map=new HashMap<>();
        long ans=-1;
        for (int i=0;i<n;++i){
            zhi[i]=scanner.nextLong();
            ans=Math.max(ans,zhi[i]);
            map.put(zhi[i], map.getOrDefault(zhi[i],0L)+1);
        }
        System.out.println(n-map.get(ans));
    }
}
