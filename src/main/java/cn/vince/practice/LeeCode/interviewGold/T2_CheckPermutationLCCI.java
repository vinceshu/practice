package cn.vince.practice.LeeCode.interviewGold;

import java.util.*;

/**
 * @author: vince.shu
 * @description: 判定是否互为字符重排
 * @date: 2022/6/3 10:42
 * @version: 1.0
 */
public class T2_CheckPermutationLCCI {
    /**
     *给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     */

    public static void main(String[] args) {
        String s1 = "abcc";
        String s2 = "bcaa";

        //boolean b = CheckPermutation(s1, s2);
        boolean b = CheckPermutationBySort(s1, s2);
        System.out.println(b);
    }


    /**
     * @author vinceshu
     * @date 2022/6/3 15:35
     * @description 将两个字符串变为数组，再逐一比较两个数组每个元素的值
     */
    public static boolean CheckPermutationBySort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                return false;
            }
        }
        return true;
    }



    /**
     * @author vinceshu
     * @date  11:01
     * @description 两个map分别记录 字符和个数，再逐一对比
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s1Map.containsKey(c)) {
                s1Map.put(c, s1Map.get(c) + 1);
                continue;
            }
            s1Map.put(c, 1);
        }

        Map<Character, Integer> s2Map = new HashMap<>(s2.length());
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (s2Map.containsKey(c)) {
                s2Map.put(c, s2Map.get(c) + 1);
                continue;
            }
            s2Map.put(c, 1);
        }

        for (Map.Entry<Character, Integer> s1Entry : s1Map.entrySet()) {
            Character key = s1Entry.getKey();
            if (!s2Map.containsKey(key) || !Objects.equals(s2Map.get(key), s1Entry.getValue())) {
                return false;
            }
        }

        return true;
    }
}
