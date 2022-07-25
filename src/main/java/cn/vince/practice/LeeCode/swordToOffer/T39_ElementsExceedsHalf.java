package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 数组中出现次数超过一半的数字
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 11:42
 */
public class T39_ElementsExceedsHalf {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement1(nums);

        System.out.println(i);
    }


    /**
     * hashmap装数字字数
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num) && map.get(num) > (nums.length / 2)) {
                result = num;
                break;
            }
        }
        return result;
    }

    /**
     * 解法一：排序，元素数量超过数组一半，必定在中间
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
