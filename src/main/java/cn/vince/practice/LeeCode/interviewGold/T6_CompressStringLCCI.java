package cn.vince.practice.LeeCode.interviewGold;

import io.netty.util.internal.StringUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: vince.shu
 * @date: 2022/6/6 21:16
 * @description: TODO
 * @version: 1.0
 */
public class T6_CompressStringLCCI {

    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     */

    public static void main(String[] args) {
        String S = "aabcccccaaa";
        String s = compressString(S);
        System.out.println(s);
    }

    public static String compressString(String S) {
        if (StringUtil.isNullOrEmpty(S)) {
            return S;
        }
        char[] chars = S.toCharArray();
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i+1 < chars.length && chars[i] == chars[i+1]) {
                count++;
            } else {
                result.append(chars[i]).append(count);
                count = 1;
            }
        }

        if (result.length() >= S.length()) return S;
        return result.toString();
    }




}
