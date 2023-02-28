package com.example.leetcode.zuo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();

        int sum=0;
        int a[]=new int[n];
     for (int i=0;i<n;++i){
         a[i]= sc.nextInt();
         sum+=dfs(a[i]);
     }
        System.out.println(sum);
    }

    private static int dfs(int sum) {
        if (sum==1) return 0;
        if (sum==2) return 1;
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        if (map.containsKey(sum)) return map.get(sum);
        int ans=sum-1;
        ans=Math.min(dfs(sum-1)+1,ans);
        for (int i=2;i<Math.sqrt(sum);i++){
            if (sum%i==0){
                int le=map.containsKey(sum/i)?map.get(sum/i):dfs(sum/i);
                int ri=map.containsKey(i)?map.get(i):dfs(i);
                map.put(sum/i,le);
                map.put(i,ri);
                ans=Math.min(le+ri+i,ans);
            }
        }
        map.put(sum,ans);
        return ans;
    }
}
