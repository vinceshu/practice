package cn.vince.practice.LeeCode.all;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: vince.shu
 * @date: 2022/6/12 10:48
 * @description: 最大子数组和
 * @version: 1.0
 */
@Slf4j
public class T53_MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = test(nums);
        log.info( "result:{}", i);
    }

    public static int test(int[] nums) {
        int temp = 0, maxResult = nums[0];
        for (int num : nums) {
            temp = Math.max(temp + num, num);
            maxResult = Math.max(temp, maxResult);
        }
        return maxResult;
    }


    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        int temp = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(temp + nums[i] >= nums[i]) {
                temp = temp + nums[i];
            } else {
                temp = nums[i];
            }

            if(temp > result) {
                result = temp;
            }
        }

        return result;


    }
}
