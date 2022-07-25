package cn.vince.practice.LeeCode.swordToOffer;

import java.util.Arrays;

/**
 * @ClassName 最小的k个数
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/14 23:56
 */
public class T40_TheMinimumNumberOfK {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     */


    public static void main(String[] args) {
        int[] nums = {0,1,2,1};
        int k = 1;
        int[] leastNumbers = getLeastNumbers(nums, k);

        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

}
