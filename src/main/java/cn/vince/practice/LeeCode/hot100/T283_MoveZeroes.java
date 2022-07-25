package cn.vince.practice.LeeCode.hot100;

import java.util.Arrays;

/**
 * @author: vince.shu
 * @description: 移动零
 * @date: 2022/7/3 11：22
 * @version: 1.0
 */
public class T283_MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return;
        }
        //第一次变量，j指针记录非0的个数，只要是非0的全都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
