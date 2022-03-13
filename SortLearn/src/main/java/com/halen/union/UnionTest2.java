package com.halen.union;

import com.halen.entity.Student;
import com.halen.sort.utils.Asserts;

public class UnionTest2 {
    public static void main(String[] args) {
        GenericUnionFind<Student> uf = new GenericUnionFind<>();

        Student stu1 = new Student(1, "jack");
        Student stu2 = new Student(2, "rose");
        Student stu3 = new Student(3, "jack");
        Student stu4 = new Student(4, "jack");

        uf.makeSet(stu1);
        uf.makeSet(stu2);
        uf.makeSet(stu3);
        uf.makeSet(stu4);

        uf.union(stu1, stu2);
        uf.union(stu3, stu4);

        Asserts.test(uf.isSame(stu1, stu2));
        Asserts.test(uf.isSame(stu3, stu4));
        Asserts.test(!uf.isSame(stu1, stu3));
    }
}
