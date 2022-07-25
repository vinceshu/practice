package cn.vince.practice.LeeCode.sort;

import java.util.Arrays;

/**
 * @author: vince.shu
 * @description: 快排
 * @date: 2022/7/5 21:27
 * @version: 1.0
 */
public class QuickSort {

    /**
     * 1、选择最右元素作为基准点元素
     * 2、j指针负责找到比基准点小的元素，一旦找到则与i进行交换
     * 3、i指针维护小于基准点元素的边界，也是每次交换的目标索引
     * 4、最后基准点与i交换，i即为分区位置
     * @param args
     */

    public static void main(String[] args) {
        int[] array = {1,5,8,11,44,63,33,45,21,40,89,99,12,42,52};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = singleQuickSort(array, left, right);
        singleQuickSort(array, left, p - 1);
        singleQuickSort(array, p + 1, right);
    }


    public static int singleQuickSort(int[] array, int left, int right) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int pv = array[right];
        int i = left;
        for (int j = 0; j < right; j++) {
            if (array[j] < pv && i < array.length - 1) {
                swap(array, i, j);
                i++;
            }
        }
        if (right < array.length - 1) {
            swap(array, right, i);
        }
        return i;
    }


    /**
     * 交换元素位置
     * @param array
     * @param indexA
     * @param indexB
     */
    public static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

}
