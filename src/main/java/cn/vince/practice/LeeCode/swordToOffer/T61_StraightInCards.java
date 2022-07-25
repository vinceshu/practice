package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 扑克牌中的顺子
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 17:18
 */
public class T61_StraightInCards {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     */

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5};
        boolean straight = isStraight1(nums);

        System.out.println(straight);

    }

    /**
     * 排序 + 遍历
     * @param nums
     * @return
     */
    public static boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int jokerNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                jokerNum++;
            } else if (nums[i] == nums[i+1]) {
                return false;
            }
        }

        return nums[4] - nums[jokerNum] < 5;
    }

    /**
     * set + 遍历 ； 最大值 - 最小值 <= 4，  0不算
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }

}
