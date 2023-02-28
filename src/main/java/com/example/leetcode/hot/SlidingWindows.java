package com.example.leetcode.hot;

import java.util.HashMap;
import java.util.Map;


/**
 * 滑动窗口算法框架
 */
public class SlidingWindows{
    void slidingWindows(String s,String t){
    Map<Character,Integer> need=new HashMap<Character,Integer>();
    Map<Character,Integer> window=new HashMap<Character,Integer>();
    for(char c:t.toCharArray()){
        need.put(c,need.getOrDefault(c,0)+1);
    }
    int left=0,right=0;
    int valid=0;
    while(right<s.length()){
        //c是将移入窗口的字符
        char c=s.charAt(right);
        //拓展右边界
        right++;
        //进行窗口内数据的一系列更新
        System.out.println(left+" "+right);
    }
    //判断左窗口是否需要收缩
        while(true){
            //需要移出去的字符
            char d =s.charAt(left);
            //左移窗口
            left++;
            //进行窗口内数据的一系列更新
        }
    }

}
