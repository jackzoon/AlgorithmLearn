package com.halen.sort1;

public class Code06_PrintB {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
    public static void main(String[] args) {
        int num = 83928328;
        print(num);
        System.out.println();
        System.out.println(Integer.toBinaryString(num));
        print(-1);
    }
}
