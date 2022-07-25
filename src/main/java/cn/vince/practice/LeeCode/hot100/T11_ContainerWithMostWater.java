package cn.vince.practice.LeeCode.hot100;

/**
 * @ClassName 盛最多水的容器
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/18 11:30
 */
public class T11_ContainerWithMostWater {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     */

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);

        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int leftIdx = 0, rightIdx = height.length - 1;
        int result = 0;
        while (leftIdx < rightIdx) {
            result = height[leftIdx] > height[rightIdx] ?
                    Math.max(result, (rightIdx - leftIdx) * height[rightIdx--]) :
                    Math.max(result, (rightIdx - leftIdx) * height[leftIdx++]);
        }
        return result;
    }
}
