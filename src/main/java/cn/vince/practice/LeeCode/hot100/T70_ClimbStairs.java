package cn.vince.practice.LeeCode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: vince.shu
 * @description: 爬楼梯
 * @date: 2022/7/3 10:39
 * @version: 1.0
 */
public class T70_ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     */

    private static Map<Integer, Integer> storeMap = new HashMap<>();

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (null != storeMap.get(n)) {
            return storeMap.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            storeMap.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        //System.out.println(climbStairs(2));
        System.out.println(climbStairs(6));
        //System.out.println(climbStairs(10));

    }

}
