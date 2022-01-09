package com.mj.set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new ListSet<>();
        set.add(10);
        set.add(11);
        set.add(11);
        set.add(13);
        set.add(13);
        set.add(15);

        set.traversal(new Set.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
