package com.example.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

public class MinWindow{
    Map<Character, Integer> ori=new HashMap<Character,Integer>();
    Map<Character, Integer> cnt=new HashMap<Character,Integer>();
    public String minWindow(String s,String t){
        int tLen=t.length();
        for (int i=0;i<tLen;++i){
            char c=t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l=0,r=-1;
        int len=Integer.MAX_VALUE,ansL=-1,ansR=-1;
        int sLen=s.length();
        while(r<sLen){
            ++r;

        }
        return s;
    }

}
