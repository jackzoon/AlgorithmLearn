package com.halen.sort;

import java.text.DecimalFormat;

public abstract class Sort implements Comparable<Sort>{

    protected Integer[] arr;
    private int cmpCount;
    private int swapCount;
    private long time;

    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        this.arr = arr;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(Sort o) {
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
        return arr[i] - arr[j];
    }

    protected int cmpElements(Integer v1, Integer v2) {
        cmpCount++;
        return v1 - v2;
    }

    protected abstract void sort();

    protected void swap(int i, int j) {
        swapCount++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        return "【" + getClass().getSimpleName() + "】\n"
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
}
