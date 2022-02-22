package com.halen.sort;

import com.halen.sort.utils.Asserts;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        Asserts.test(indexOf(arr, 4) == 1);
        Asserts.test(indexOf(arr, 2) == 0);
        Asserts.test(indexOf(arr, 10) == 4);
        Asserts.test(indexOf(arr, 55) == -1);

        int[] arr1 = {2, 4, 8, 8, 8, 12, 14};
        Asserts.test(search(arr1, 5) == 2);
        Asserts.test(search(arr1, 1) == 0);
        Asserts.test(search(arr1, 15) == 7);
        Asserts.test(search(arr1, 8) == 5);

    }

    /**
     * 查找v在有序数组中待插入的位置
     * @param arr
     * @param v
     * @return
     */
    public static int search(int[] arr, int v) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < arr[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    /**
     * 查找v在有序数组中的位置
     * @param arr
     * @param v
     * @return
     */
    public static int indexOf(int[] arr, int v) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < arr[mid]) {
                end = mid;
            } else if (v > arr[mid]) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
