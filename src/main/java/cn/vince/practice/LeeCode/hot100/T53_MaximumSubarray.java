package cn.vince.practice.LeeCode.hot100;

/**
 * @ClassName 最大子数组和
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/18 10:50
 */
public class T53_MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);

        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int tempSum = 0, result = nums[0];
        for (int num : nums) {
            if (tempSum > 0) {
                tempSum += num;
            } else {
                tempSum = num;
            }
            result = Math.max(result, tempSum);
        }
        return result;
    }
}
