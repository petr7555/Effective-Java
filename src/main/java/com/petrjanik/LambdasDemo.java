package com.petrjanik;

import java.util.*;

/**
 * @author Petr Janik 485122
 * @since 10.02.2020
 */
public class LambdasDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Bob", "Charlie", "Anna");
//        Collections.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });

        words.sort(Comparator.comparingInt(String::length));

        System.out.println(words);
    }
}
