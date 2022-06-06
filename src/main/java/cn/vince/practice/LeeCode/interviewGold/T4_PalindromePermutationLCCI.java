package cn.vince.practice.LeeCode.interviewGold;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: vince.shu
 * @description: 回文排列
 * @date: 2022/6/5 11:45
 * @version: 1.0
 */
public class T4_PalindromePermutationLCCI {

    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     */

    public static void main(String[] args) {
        String s = "tactcoa";
        boolean result = canPermutePalindrome(s);
        System.out.println(result);
    }



    public static boolean canPermutePalindrome(String s) {

        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }


}
