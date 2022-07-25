package cn.vince.practice.LeeCode.swordToOffer;

/**
 * @ClassName  左旋转字符串
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/16 11:49
 */
public class T58_LeftRotationString {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     */

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String result = reverseLeftWords1(s, k);

        System.out.println(result);
    }

    /**
     * 不允许用现有函数
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords1(String s, int n) {
        String result = "";
        for (int i = n; i < s.length(); i++) {
            result += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result += s.charAt(i);
        }
        return result;
    }

    /**
     * 利用 subString
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
