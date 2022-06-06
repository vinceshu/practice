package cn.vince.practice.LeeCode.interviewGold;

import org.elasticsearch.common.util.Maps;

import java.util.*;

/**
 * @author: vince.shu
 * @description: 判定字符是否唯一
 * @date: 2022/6/3 10:12
 * @version: 1.0
 */
public class T1_IsUniqueLCCI {

    public static void main(String[] args) {
        String astr = "leetcode";
        //boolean unique = isUniqueWithMap(astr);
        boolean unique = isUniqueWithSet(astr);
        System.out.println(unique);
    }


    /**
     * @author vinceshu
     * @date  10:32
     * @description 用map判断是否存在
     */
    public static boolean isUniqueWithSet(String astr) {
        Set<Character> set = new HashSet<>();
        for(int i= 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author vinceshu
     * @date  10:32
     * @description 用map判断是否存在
     */
    public static boolean isUniqueWithMap(String astr) {
        Map<String, String> map = new HashMap<>();
        for(int i= 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            String s = String.valueOf(c);
            if (!map.isEmpty() && map.containsKey(s)) {
                return false;
            }
            map.put(s, s);
        }
        return true;
    }

}
