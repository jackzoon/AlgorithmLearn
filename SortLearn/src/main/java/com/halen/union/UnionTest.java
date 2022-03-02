package com.halen.union;

import com.halen.sort.utils.Times;

public class UnionTest {

    static final int count = 2000000;

    public static void main1(String[] args) {
        UnionFind unionFind = new UnionFind_QU_S(12);
        unionFind.union(0, 1);
        unionFind.union(0, 3);
        unionFind.union(0, 4);
        unionFind.union(2, 3);
        unionFind.union(2, 5);

        unionFind.union(6, 7);

        unionFind.union(8, 10);
        unionFind.union(9, 10);
        unionFind.union(9, 11);

        System.out.println(unionFind.isSame(0, 6));
        System.out.println(unionFind.isSame(0, 5));
    }


    public static void main(String[] args) {

        testTime(new UnionFind_QU_S(count));
        testTime(new UnionFind_QU_R(count));
        testTime(new UnionFind_QU_R_PC(count));
    }

    static void testTime(UnionFind uf) {
        Times.test(uf.getClass().getSimpleName(),() -> {
            for (int i = 0; i < count; i++) {
                uf.union((int) (Math.random() * count), (int) (Math.random() * count));
            }
            for (int i = 0; i < count; i++) {
                uf.isSame((int) (Math.random() * count), (int) (Math.random() * count));
            }
        });
    }
}
