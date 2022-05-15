package com.halen.sort1;

public class Code02_RandToRand {


    public static void main(String[] args) {
        System.out.println("测试开始");
        int testTimes = 100000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.5) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);

        System.out.println("=====================");
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);
        System.out.println("------------");
        int K = 9;
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i]);
        }

        System.out.println("========================");
        count = 0;
        double x = 0.7;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);

        System.out.println("------------------");
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double)count / (double)testTimes);
        System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=-=");
        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = f3();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i]);
        }
    }

    // 返回[0,1)的一个小数
    // 任意的x,x属于[0,1),[0,x)范围上的数出现概率由原来的x调整成x平方
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 随机机制，只能用f1，等功率返回0和1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 得到000 ~ 111 做到等概率 0~7等概率返回一个
    public static int f3() {
        int ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        return ans;
    }

    // 得到等概率 0~6返回一个
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

}
