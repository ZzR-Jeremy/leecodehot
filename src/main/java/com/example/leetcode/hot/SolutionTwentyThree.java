package com.example.leetcode.hot;

import java.util.*;
//返回同素异构体
public class SolutionTwentyThree {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<String, List<String>>();
        for (String str :strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            //获取指定Key对应的value 如果没有就返回默认值
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public List<List<String>> dummy(String[] strs) {
        Map<String,List<String>> map=new HashMap<String, List<String>>();
        for (String str:strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }


        public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map=new HashMap<String, List<String>>();
        for(String str:strs){
            int[] counts=new int[26];
            int len=str.length();
            for (int i=0;i<len;++i){
            counts[str.charAt(i)-'a']++;
            }
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<26;++i){
                if(counts[i]!=0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key=sb.toString();
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
