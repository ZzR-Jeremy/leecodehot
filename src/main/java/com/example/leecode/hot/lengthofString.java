package com.example.leecode.hot;

import java.util.HashSet;
import java.util.Set;

class lengthofString {

    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int Max=1;
        if(n<=1) return n;
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;i++){
                if (allUnique(s,i,j))
                    Max=Math.max(Max,j-i+1);
                }
            }
        return Max;
    }
    private boolean allUnique(String s,int start, int end){
        Set<Character> set=new HashSet<>();
        for(int i=start;i<=end;i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
}