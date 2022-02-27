package com.halen.sort;

/**
 * 计数排序
 */
public class CountingSort extends Sort<Integer>{

    @Override
    protected void sort() {
        // 找出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[1 + max];
        // 统计每个整数出现的次数
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        // 根据整数的出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
}
