package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 在排序数组中查找数字 I
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 11:55
 */
public class T53_FindNumberInAnArray {

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     */

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;

        int search = search2(nums, target);

        System.out.println(search);
    }

    /**
     * 双指针（不好实现）
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 1;
            else return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] != target) {
                left++;
            }
            while (left < right && nums[right] != target) {
                right--;
            }
            if (right > left) {
                return right - left + 1;
            }
        }
        return 0;
    }

    /**
     * 暴力，不用map，空间复杂减少
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                num++;
            }
        }
        return num;
    }

    /**
     * 暴力map
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num == target) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        if (map.isEmpty()) {
            return 0;
        }
        return (int)map.values().toArray()[0];
    }
}
