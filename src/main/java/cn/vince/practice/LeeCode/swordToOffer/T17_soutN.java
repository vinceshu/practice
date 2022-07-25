package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;

/**
 * @ClassName 打印从1到最大的n位数
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 11:04
 */
public class T17_soutN {

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     */

    public static void main(String[] args) {
        int n = 2;
        int[] ints = printNumbers(n);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] ints = new int[end];
        for (int i = 0; i < end; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

}
