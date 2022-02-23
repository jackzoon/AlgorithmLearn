package com.halen.sort;

import com.halen.sort.utils.Asserts;
import com.halen.sort.utils.Integers;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] arr = Integers.random(20000, 1, 20000);
        testSorts(arr,
                new HeapSort<Integer>(),
                new SelectionSort<Integer>(),
                new BubbleSort3<Integer>(),
                new InsertionSort<Integer>(),
                new InsertionSort2<Integer>(),
                new MergeSort<Integer>()
        );
    }

    static void testSorts(Integer[] arr, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArr = Integers.copy(arr);
            sort.sort(newArr);
            Asserts.test(Integers.isAscOrder(newArr));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
