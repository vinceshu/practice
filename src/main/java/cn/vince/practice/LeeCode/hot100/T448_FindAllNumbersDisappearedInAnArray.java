package cn.vince.practice.LeeCode.hot100;

import java.util.List;

/**
 * @ClassName 找到所有数组中消失的数字
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 18:00
 */
public class T448_FindAllNumbersDisappearedInAnArray {

    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     *
     * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     */


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers1(nums);

        System.out.println(result);
    }


    /**
     * 额外
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {


        return null;
    }
}
