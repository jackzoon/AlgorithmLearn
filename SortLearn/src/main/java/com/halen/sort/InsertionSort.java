package com.halen.sort;

/**
 * 插入排序
 * 类似于扑克牌的排序
 * 执行流程
 * 1、在执行过程中，插入排序会将序列分为2部分
 * 1.1、头部是已经排好序的，尾部是待排序的
 * 2、从头开始扫描每一个元素
 * 2.1、每当扫描到一个元素，就将它插入到头部合适的位置，使得头部数据依然保持有序
 *
 * 插入排序的时间复杂度与逆序对的数量成正比关系
 * 逆序对的数量越多，插入排序的时间复杂度越高
 */
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }

    protected void sort1() {
        for (int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            E v = arr[begin];
            while (cur > 0 && cmp(v, arr[cur - 1]) < 0) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            arr[cur] = v;
        }
    }
}
