package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;

/**
 * @ClassName 调整数组顺序使奇数位于偶数前面
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 11:23
 */
public class T21_AdjustArrayOrder {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] exchange = exchange(nums);

        System.out.println(Arrays.toString(exchange));
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        return nums;
    }
}
