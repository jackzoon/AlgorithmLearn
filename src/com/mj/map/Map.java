package com.mj.map;

public interface Map<K, V> {
    int size();

    boolean isEmpty();

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    public static abstract class Visitor<K, V> {
        boolean stop;

        abstract boolean visit(K key, V value);
    }

}
