package basic.class_01;

import java.util.Arrays;
import java.util.Comparator;

public class Code_09_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", ID : " + student.id + ", Age : " + student.age);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);
        Student[] students = new Student[]{student3, student2, student1};
        printStudents(students);

        System.out.println("---------------------------------------");

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        System.out.println("---------------------------------------");

    }



}
