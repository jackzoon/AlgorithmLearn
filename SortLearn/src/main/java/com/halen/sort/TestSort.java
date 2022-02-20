package com.halen.sort;

import com.halen.sort.utils.Integers;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] arr = Integers.random(10000, 1, 20000);
        testSorts(arr,
                new HeapSort(),
                new SelectionSort(),
                new BubbleSort3(),
                new BubbleSort2(),
                new BubbleSort1()
        );
    }

    static void testSorts(Integer[] arr, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(arr));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
