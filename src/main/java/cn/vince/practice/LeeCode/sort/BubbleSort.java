package cn.vince.practice.LeeCode.sort;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        int[] array = {1,5,8,11,44,63,33,45,21,40,89,99,12,42,52};
        bubble(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubble1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }


    public static void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
