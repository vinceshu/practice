package cn.vince.practice.LeeCode.swordToOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName 第一个只出现一次的字符
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/15 16:59
 */
public class T50_FirstCharacter {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     */

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstUniqChar1(s);

        System.out.println(c);
    }

    /**
     * 普通hash， k：元素， v：出现次数；
     * @param s
     * @return
     */
    public static char firstUniqChar1(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 有序hash，k：char  v：是否出现一次   顺序遍历
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

}
