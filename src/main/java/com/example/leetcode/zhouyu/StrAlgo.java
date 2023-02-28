package com.example.leetcode.zhouyu;

import java.util.Arrays;

public class StrAlgo {
    /**
     * 替换空格
     * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static String replaceSpace(StringBuffer str){
       int len=str.length();
        StringBuffer result=new StringBuffer();
        for (int i=0;i<len;i++){
            char b=str.charAt(i);
            if (String.valueOf(b).equals(" ")){
                result.append("%20");
            }else{
                result.append(b);
            }
        }
        return result.toString();
    }
    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     */
    private static boolean checkStrs(String[] strs){
        boolean flag=false;

        if (strs!=null){
        for (int i=0;i<strs.length;i++){
            if (strs[i]!=null&&strs[i].length()!=0){
                flag=true;
            }else{
                flag=false;
                break;
            }
        }

        }
        return flag;
    }
    public static String longestFont(String[] strs){
        if(!checkStrs(strs)) return "";
        int len=strs.length;
        StringBuffer result=new StringBuffer();
        //元素升序排序
        Arrays.sort(strs);
        int m=strs[0].length();
        int n=strs[len-1].length();
        int num=Math.min(n,m);
        for (int i=0;i<num;i++){
            if (strs[0].charAt(i)==strs[len-1].charAt(i)){
                result.append(strs[0].charAt(i));
            }else break;
        }
        return result.toString();
    }

}
