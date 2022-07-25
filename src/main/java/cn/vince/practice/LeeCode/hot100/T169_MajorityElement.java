package cn.vince.practice.LeeCode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 多数元素
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 17:38
 */
public class T169_MajorityElement {


    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement2(nums);

        System.out.println(result);
    }


    /**
     * 排序
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 用map存储值和数量
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = nums[0];
        int count = nums.length / 2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > count) {
                    result = num;
                    break;
                }
            } else {
                map.put(num, 1);
            }
        }
        return result;
    }
}
