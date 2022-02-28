package com.halen.sort;

/**
 * 基数排序
 * 基数排序非常适用于整数排序（尤其是负整数），
 * 执行流程：依次对个位数、十位数、百位数、千位数、万位数...进行排序（从低位到高位)
 */
public class RadixSort extends Sort<Integer>{

    @Override
    protected void sort() {
        // 找出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }

    }

    protected void countingSort(int divider) {
        // 开辟内存空间，存储次数
        int[] counts = new int[10];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] / divider % 10]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // 从后往前遍历元素，将它放到有序数组中的合适位置
        int[] newArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newArr[--counts[arr[i] / divider % 10]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
