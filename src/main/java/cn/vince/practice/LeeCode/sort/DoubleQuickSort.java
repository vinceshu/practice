package cn.vince.practice.LeeCode.sort;

import java.util.Arrays;

/**
 *  快速排序  双边循环
 */
public class DoubleQuickSort {

    public static void main(String[] args) {
        int[] array = {5,4,2,6,3,1,8,9};
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
        int pv = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] > pv) {
                j--;
            }

            while (i < j && array[i] <= pv) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, left, j);
        System.out.println(Arrays.toString(array) + "   ,  j = " + j);
        return j;
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
