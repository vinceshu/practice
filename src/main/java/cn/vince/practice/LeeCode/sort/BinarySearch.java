package cn.vince.practice.LeeCode.sort;


import java.util.Arrays;

public class BinarySearch {

    /**
     * 二分查找
     * 1、先将数组排好序
     * 2、从数组中间开始查找，若target < middle, 去左边开始查找；若targe < middle 去右边开始查找
     */

    public static void main(String[] args) {
        int[] array = {1,5,8,11,44,63,33,45,21,40,89,99,12,42,52};
        int target = 42;
        int i = binarySearch(array, target);
        System.out.println(i);

    }

    public static int binarySearch(int[] array, int target) {
        if (array.length <= 0) {
            return -1;
        }
        Arrays.sort(array);
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (target == array[middleIndex]) {
                return array[middleIndex];
            }
            if (target > array[middleIndex]) {
                leftIndex = middleIndex;
            } else {
                rightIndex = middleIndex;
            }
        }
        return -1;
    }

}
