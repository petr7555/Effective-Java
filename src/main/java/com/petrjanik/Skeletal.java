package com.petrjanik;

import java.util.*;

/**
 * @author Petr Janik 485122
 * @since 11/08/2019
 */
public class Skeletal {
    static List<Integer> intArrayAsList(int[] a) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public Integer set(int index, Integer value) {
                int oldValue = a[index];
                a[index] = value;
                return oldValue;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
