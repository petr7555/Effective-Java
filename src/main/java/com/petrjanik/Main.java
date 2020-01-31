package com.petrjanik;

import java.util.*;

/**
 * @author Petr Janik 485122
 * @since 07/09/2019
 */
public class Main {
    public static void main(String[] args) {

//        List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(42));
//        String s = strings.get(0);
        Object[] objectArray = new Long[1];
        objectArray[0] = "a";
//        List<String>[] stringLists = new List<String>[1];
//        List<Integer> intList = Collections.singletonList(42);
//        Object[] objects = stringLists;
//        objects[0] = intList;
//        String s = stringLists[0].get(0);
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(0);
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
