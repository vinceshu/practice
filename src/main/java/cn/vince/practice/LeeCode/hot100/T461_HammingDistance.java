package cn.vince.practice.LeeCode.hot100;

/**
 * @ClassName T461_HammingDistance  汉明距离
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 17:02
 */
public class T461_HammingDistance {

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     *
     *
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     */

    public static void main(String[] args) {
        int x = 1,y = 4;
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }


    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
