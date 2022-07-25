package cn.vince.practice.LeeCode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName 三数之和
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/18 11:50
 */
public class T15_ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     */

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序，nums变成递增数组
        List<List<Integer>> res = new ArrayList<>();
        //k < nums.length - 2是为了保证后面还能存在两个数字
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;//若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if(k > 0 && nums[k] == nums[k - 1]) continue;//nums[k]值重复了，去重
            int i = k + 1, j = nums.length - 1;//定义左右指针
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);//左指针前进并去重
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);//右指针后退并去重
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);//左指针前进并去重
                    while(i < j && nums[j] == nums[--j]);//右指针后退并去重
                }
            }
        }
        return res;
    }
}
