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
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < arr.length; begin++) {
            int insertIndex = search(begin);
            E v = arr[begin];
            // 将[insertIndex,begin)范围内的元素往右边挪动一个单位
            for (int i = begin; i > insertIndex; i--) {
                arr[i] = arr[i - 1];
            }
            arr[insertIndex] = v;
        }
    }

    /**
     * 利用二分搜索找到index位置元素的待插入位置
     * 已经排好序数组的区间范围是[0,index)
     * @param index
     * @return
     */
    private int search(int index) {
        E v = arr[index];
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(v, arr[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

}
