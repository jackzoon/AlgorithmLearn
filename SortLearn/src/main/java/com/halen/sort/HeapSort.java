package com.halen.sort;

/**
 * 堆排序
 * 1、对序列进行原地建堆(heapify)
 * 2、重复执行以下操作，直到堆的元素数量为1
 * 2.1、交换堆顶元素与尾元素
 * 2.2、堆的元素数量减1
 * 2.3、对0位置进行1次siftDown操作
 */
public class HeapSort<E extends Comparable<E>> extends Sort<E>{

    private int heapSize;

    @Override
    protected void sort() {
        //原地建堆
        heapSize = arr.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            //交换堆顶元素和尾部元素
            swap(0, --heapSize);
            // 对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        E element = arr[index];
        int half = heapSize >> 1;
        while (index < half) {
            // 默认是左边跟父节点比
            int childIndex = (index << 1) + 1;
            E child = arr[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize && cmp(arr[rightIndex], child) > 0) {
                child = arr[childIndex = rightIndex];
            }
            // 大于等于子节点
            if (cmp(element, child) >= 0) {
                break;
            }

            arr[index] = child;
            index = childIndex;
        }
    }
}
