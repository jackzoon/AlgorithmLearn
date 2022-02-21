package com.halen.sort;

import com.halen.sort.utils.Asserts;
import com.halen.sort.utils.Integers;

/**
 * 选择排序的交换次数要远远小于冒泡排序，平均性能优于冒泡排序
 * 最好、最坏、平均时间复杂度为O(n^2)，空间复杂度为O(1)，属于稳定排序
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E>{
    @Override
    public void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin,maxIndex) >=0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }



}
