package cn.vince.practice.LeeCode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 只出现一次的数字
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/12 17:08
 */
public class T136_SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。(你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？)
     *
     * 输入: [2,2,1]
     * 输出: 1
     */

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int result = singleNumber1(nums);

        System.out.println(result);
    }


    /**
     * 位运算
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }





    /**
     * 不使用额外空间实现1：先排序，然后加一个元素 减一个元素，最后的结果就是唯一的元素
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result += nums[i];
            } else {
                result -= nums[i];
                if (result != 0) {
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 不使用额外空间实现
     * @param nums
     * @return
     */
    public static int singleNumberWithSpace(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
                continue;
            }
            map.put(nums[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
