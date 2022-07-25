package cn.vince.practice.LeeCode.interviewGold;

/**
 * @author: vince.shu
 * @date: 2022/6/7 21:54
 * @description: 字符串轮转
 * @version: 1.0
 */
public class T9_StringRotationLCCI {

    /**
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     *
     *  输入：s1 = "waterbottle", s2 = "erbottlewat"
     *  输出：True
     * @param args
     */

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean flipedString = isFlipedString(s1, s2);
        System.out.println(flipedString);
    }


    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        return s.contains(s1);
    }

}
