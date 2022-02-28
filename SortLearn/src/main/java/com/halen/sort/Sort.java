package com.halen.sort;

import com.halen.sort.bean.Student;

import java.text.DecimalFormat;

public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>>{

    protected E[] arr;
    private int cmpCount;
    private int swapCount;
    private long time;

    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        this.arr = arr;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(Sort<E> o) {
        int result = (int) (time - o.time);
        if (result != 0) {
            return result;
        }
        result = cmpCount - o.cmpCount;
        if (result != 0) {
            return result;
        }
        result = swapCount - o.swapCount;
        return result;
    }

    /**
     * 返回值等于0，代表arr[i] == arr[j]
     * 返回值小于0，代表arr[i] < arr[j]
     * 返回值大于0，代表arr[i] > arr[j]
     * @param i
     * @param j
     * @return
     */
    protected int cmp(int i, int j) {
        cmpCount++;
        return arr[i].compareTo(arr[j]);
    }

    protected int cmp(E v1, E v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected abstract void sort();

    protected void swap(int i, int j) {
        swapCount++;
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        String stableStr = "稳定性: " + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }

    private boolean isStable() {
        if (this instanceof CountingSort) {
            return false;
        }
        if (this instanceof CountingSort2) {
            return true;
        }
        if (this instanceof ShellSort) {
            return false;
        }
        if (this instanceof RadixSort) {
            return true;
        }
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((E[])students);
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i - 1].score;
            if (score != prevScore + 10) {
                return false;
            }
        }
        return true;
    }
}
