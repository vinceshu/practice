package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 最长不含重复字符的子字符串
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 22:30
 */
public class T48_TLSWRC {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);

        System.out.println(result);
    }


    public static int lengthOfLongestSubstring(String s) {
        /*int left = 0, right = 0, resultLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
            }
            set.add(c);
            right++;
        }

        return resultLength;*/
        return 0;
    }
}
