package com.halen.sort;

public class CountingSort2 extends Sort<Integer>{

    @Override
    protected void sort() {
        // 找出最大值,最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - min]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // 从后往前遍历元素，将它放到有序数组中的合适位置
        int[] newArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newArr[--counts[arr[i] - min]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
