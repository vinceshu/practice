package cn.vince.practice.LeeCode.swordToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 0～n-1中缺失的数字
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 15:34
 */
public class T53_LostNum {

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     */

    public static void main(String[] args) {
        int[] nums = {0};
        int i = missingNumber2(nums);

        System.out.println(i);
    }

    /**
     * 有序数组， 考虑二分
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int leftIdx = 0, rightIdx = nums.length - 1;
        while (leftIdx <= rightIdx) {
            int middleIdx = (leftIdx + rightIdx) / 2;
            //不存在的数 在右侧
            if (nums[middleIdx] == middleIdx) {
                leftIdx = middleIdx + 1;
            } else {
                //在左侧
                rightIdx = middleIdx - 1;
            }
        }

        return leftIdx;
    }


    /**
     * 数学思路：缺失元素 = 完整元素和 - 当前元素和
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n - 1) / 2;

        int curTotal = 0;
        for (int num : nums) {
            curTotal += num;
        }

        return total - curTotal;
    }

    /**
     * 遍历 + hash
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int result = -1;
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result = i;
                break;
            }
        }
        return result;
    }



}
