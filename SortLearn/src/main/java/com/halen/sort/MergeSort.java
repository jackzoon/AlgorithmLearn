package com.halen.sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArr;

    @Override
    protected void sort() {
        leftArr = (E[]) new Comparable[arr.length >> 1];
        sort(0, arr.length);
    }

    /**
     * 对 [begin,end)范围内的数据进行归并排序
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将[begin,mid) 和[mid,end)范围的序列合并成一个有序的序列
     * @param begin
     * @param mid
     * @param end
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid,re = end;
        int ai = begin;
        // 备份左边数组
        for (int i = li; i < le; i++) {
            leftArr[i] = arr[begin + i];
        }
        while (li < le) {// 如果左边还没有结束
            if (ri < re && cmp(arr[ri], leftArr[li]) < 0) { // 拷贝右边数组到arr
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = leftArr[li++]; // 拷贝左边数组到arr
            }
        }
    }
}
