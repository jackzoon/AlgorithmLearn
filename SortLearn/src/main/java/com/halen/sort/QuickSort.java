package com.halen.sort;

/**
 * 快速排序
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        sort(0, arr.length);
    }

    /**
     * 对[begin,end)范围的元素进行快速排序
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        // 确定轴点位置
        int mid = pivotIndex(begin, end);
        // 对子序列进行快速排序
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 构造出[begin,end)范围的轴点元素
     * @param begin
     * @param end
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int begin, int end) {
        // 备份begin位置的元素
        E pivot = arr[begin];
        // end指向最后一个元素
        end--;
        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, arr[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    arr[begin] = arr[end];
                    begin++;
                    break;
                }
            }

            while (begin < end) {
                if (cmp(pivot, arr[begin]) > 0) {
                    begin++;
                } else {
                    arr[end] = arr[begin];
                    end--;
                    break;
                }
            }
        }
        // 将轴点元素放入最终的位置
        arr[begin] = pivot;
        return begin;
    }
}
