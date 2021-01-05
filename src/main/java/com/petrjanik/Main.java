package com.petrjanik;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Petr Janik 485122
 * @since 07/09/2019
 */
public class Main {
    public static void main(String[] args) {
//        dangerous(Arrays.asList("ahoj"), Arrays.asList("svete"));
//        String[] strings = pickTwo("Good", "Safe", "Fast");
        List<String> strings = pickTwo2("Good", "Safe", "Fast");
        System.out.println(strings);
        List<String> friends = Arrays.asList("Bob");
        List<String> romans = Arrays.asList("Anne");
        List<String> countrymen = Arrays.asList("Julie");
        List<String> audience = flatten(Arrays.asList(friends, romans, countrymen));
        System.out.println(audience);
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(0);
    }

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = Arrays.asList(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); //Can't get here
    }

    static <T> List<T> pickTwo2(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return Arrays.asList(a, b);
            case 1:
                return Arrays.asList(a, c);
            case 2:
                return Arrays.asList(b, c);
        }
        throw new AssertionError(); //Can't get here
    }

    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {

        s1.add(null);
        int result = 0;
        for (Object o : s1) {
            if (s2.contains(o)) {
                result++;
            }
        }
        return result;
    }
}
