package com.example.leetcode.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 递归的子问题可以想象成是输入的一种简化
 */
public class SolutionNine {
    public List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<String>();
        if(digits.length()==0)
            return combinations;
        Map<Character,String> phoneMap=new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
        backTrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }
    public void backTrack(List<String> combinations, Map<Character,String> phoneMap, String digits, int index, StringBuffer combination){
        if(index==digits.length()){
            combinations.add(combination.toString());
        }else{
            //获取数字
            char digit=digits.charAt(index);
            //通过数字在映射中取出对应的字母
            String letters=phoneMap.get(digit);
            int letterCount=letters.length();
            for(int i=0;i<letterCount;++i){
                combination.append(letters.charAt(i));
                backTrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
