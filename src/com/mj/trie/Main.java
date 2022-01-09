package com.mj.trie;

public class Main {
    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("dog", 2);
        trie.add("catalog", 3);
        trie.add("cast", 4);
        trie.add("小马哥", 5);
        System.out.println(trie.size());
        System.out.println(trie.get("dog"));
        System.out.println(trie.startsWith("cat"));
    }
}
