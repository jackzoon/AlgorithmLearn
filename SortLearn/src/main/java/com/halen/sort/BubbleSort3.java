package com.halen.sort;


import com.halen.sort.utils.Integers;

public class BubbleSort3<E extends Comparable<E>> extends Sort<E>{

    public static void main(String[] args) {
        Integer[] arr = Integers.random(10, 1, 20);
        Integers.println(arr);
        new BubbleSort3().sort(arr);
        Integers.println(arr);
    }

    protected void sort() {
        for (int end = arr.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                // if (array[begin] < array[begin - 1]) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

    // 有问题，待分析
    public void sort1() {
        for (int end = arr.length; end > 0; end--) {
            // sortedIndex的初始值在数组完全有序的时候有用
            int sortedIndex = 1;
            for (int begin = 1; begin < end; begin++) {
                if (cmp(begin,begin-1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

}
