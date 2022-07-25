package cn.vince.practice.LeeCode.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: vince.shu
 * @description: 两数之和
 * @date: 2022/4/30 10:43
 * @version: 1.0
 */
@Slf4j
public class T1_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        int target = 10;
        //开始计时
        long start = System.currentTimeMillis();
        //开始执行
        //int[] result = twoSum(nums, target);
        int[] result = twoSum2(nums, target);
        log.info("result:{}, cost:{}", result, System.currentTimeMillis() - start);
    }

    /**
     * @param nums:
     * @param target:
     * @return int
     * @author vinceshu
     * @description Hash
     * @date  10:27
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    /**
     * @param nums:
     * @param target:
     * @return int
     * @author vinceshu
     * @description 暴力
     * @date  10:27
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }
}
