package com.halen.sort;


public class BubbleSort1 extends Sort{

    public void sort() {
        for (int end = arr.length; end > 0; end--) {
            for (int begin = 1; begin < end; begin++) {
                if (cmp(begin,begin-1) < 0) {
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
