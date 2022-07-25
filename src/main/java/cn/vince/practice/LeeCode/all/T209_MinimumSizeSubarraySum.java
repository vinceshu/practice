package cn.vince.practice.LeeCode.all;

/**
 * @ClassName  长度最小的子数组
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 22:12
 */
public class T209_MinimumSizeSubarraySum {

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(7, nums);

        System.out.println(result);
    }

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, curSum = 0, minLength = 0;
        while (right < nums.length) {
            curSum += nums[right];
            while (curSum >= target) {
                if (right - left + 1 < minLength || minLength == 0) {
                    minLength = right - left + 1;
                }
                curSum = curSum - nums[left];
                left++;
            }
            right++;
        }

        return minLength;
    }

}
