package cn.vince.practice.LeeCode.hot100;

import java.util.*;
import java.util.concurrent.Executors;

/**
 * @author: vince.shu
 * @description: 找到所有数组中消失的数字
 * @date: 2022/7/3 11：31
 * @version: 1.0
 */
public class T448_FindDisappearedNumbers {

    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     */

    public static void main(String[] args) {
        int[] nums = {1,1};
        List<Integer> result = findDisappearedNumbers(nums);

        System.out.println(result);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }



}
