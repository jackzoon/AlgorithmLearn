package com.mj.hashtable;

public class Main {
    public static void main(String[] args) {
        String string = "jack";
        int len = string.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            hashCode = hashCode * 31 + c;
        }
        System.out.println(hashCode);
    }
}
