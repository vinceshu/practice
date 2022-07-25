package cn.vince.practice.LeeCode.swordToOffer;

import java.util.*;

/**
 * @ClassName 和为s的两个数字
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 16:12
 */
public class T57_TwoSum {

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     */


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ints = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 有序数组， 双指针
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if(sum > target) {
                right--;
            }
            if(sum < target) {
                left++;
            }
        }
        return new int[]{};
    }

    /**
     * hash优化：set
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>(nums.length);
        int[] result = new int[2];
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(target - num);
            } else {
                result[0] = num;
                result[1] = target - num;
                break;
            }
        }
        return result;
    }

    /**
     * hash   target = a + b;   k:b  v:a
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int num : nums) {
            if (map.containsKey(num)) {
                result[0] = target - num;
                result[1] = num;
                break;
            }
            map.put(target - num, num);
        }
        return result;
    }
}
